package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerRedoxFurnace;
import net.pastek.chemicalscience.common.recipe.categories.item2item.specificmachines.RedoxFurnaceRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import org.jetbrains.annotations.Nullable;
import voltaic.api.IWrenchItem;
import voltaic.api.electricity.ICapabilityElectrodynamic;
import voltaic.api.multiblock.assemblybased.Multiblock;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.api.multiblock.assemblybased.TileMultiblockController;
import voltaic.api.multiblock.assemblybased.TileMultiblockSlave;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.common.recipe.recipeutils.*;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.CapabilityInputType;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.utilities.BlockEntityUtils;
import voltaic.registers.VoltaicCapabilities;

import java.util.List;

public class TileRedoxFurnace extends TileMultiblockController implements ITickableSound {
    public static final ResourceLocation ID = ChemicalScience.rl("redoxfurnace");
    public static final ResourceKey<Multiblock> RESOURCE_KEY = Multiblock.makeKey(ID);
    private boolean isSoundPlaying = false;

    public final SingleProperty<Double> operatingTicks = property(new SingleProperty<>(PropertyTypes.DOUBLE, "operatingticks", 0.0));
    public final SingleProperty<Boolean> isActive = property(new SingleProperty<>(PropertyTypes.BOOLEAN, "isactive", false));

    public TileRedoxFurnace(BlockPos pos, BlockState state) {
        super(CSTiles.TILE_REDOX_FURNACE.get(), pos, state);
        addComponent(new ComponentElectrodynamic(this, false, true).setInputDirections(BlockEntityUtils.MachineDirection.BOTTOM).voltage(VoltaicCapabilities.DEFAULT_VOLTAGE*8));
        addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.redoxfurnace.tag(), this).createMenu((id, player) -> new ContainerRedoxFurnace(id, player, getComponent(IComponentType.Inventory), getCoordsArray())));
        addComponent(new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().processors(1, 2, 1, 5).upgrades(3)).validUpgrades(ContainerRedoxFurnace.VALID_UPGRADES).valid(machineValidator()));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcessRedoxFurnace).process(this::process));
    }

    public boolean canProcessRedoxFurnace(ComponentProcessor pr, int procNumber) {
        boolean canProcess = canProcess(pr,procNumber);
        if (BlockEntityUtils.isLit(this) ^ canProcess) {
            BlockEntityUtils.updateLit(this, canProcess);
        }

        return canProcess;
    }

    private boolean canProcess(ComponentProcessor pr, int procNumber) {
        RedoxFurnaceRecipe locRecipe;

        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);
            locRecipe = (RedoxFurnaceRecipe) pr.getRecipe(CSRecipies.REDOX_FURNACE_TYPE.get(), procNumber);
            if (locRecipe == null) return false;
        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (RedoxFurnaceRecipe) pr.getRecipe(procNumber);
        }

        pr.setRecipe(locRecipe, procNumber);
        pr.requiredTicks.setValue((double) locRecipe.getTicks(), procNumber);
        pr.usage.setValue(locRecipe.getUsagePerTick(), procNumber);

        ComponentInventory inv = getComponent(IComponentType.Inventory);

        ComponentElectrodynamic electro = getComponent(IComponentType.Electrodynamic);
        if (electro.getJoulesStored() < pr.getUsage(procNumber)) return false;

        int outputSlot = inv.getOutputSlots().get(procNumber);
        ItemStack recipeOutput = locRecipe.getItemRecipeOutput();
        ItemStack existingOutput = inv.getItem(outputSlot);

        if (!existingOutput.isEmpty()) {
            if (!ItemStack.isSameItemSameComponents(existingOutput, recipeOutput) ||
                    existingOutput.getCount() + recipeOutput.getCount() > existingOutput.getMaxStackSize()) {
                return false;
            }
        }

        if (locRecipe.hasItemBiproducts()) {
            List<ProbableItem> itemBi = locRecipe.getItemBiproducts();
            List<Integer> biprodSlots = inv.getBiprodSlotsForProcessor(procNumber);

            for (int i = 0; i < itemBi.size(); i++) {
                int slotIndex = biprodSlots.get(i);
                ItemStack existingBi = inv.getItem(slotIndex);

                ItemStack potentialBi = itemBi.get(i).getFullStack();

                if (!existingBi.isEmpty() && !potentialBi.isEmpty()) {
                    if (!ItemStack.isSameItemSameComponents(existingBi, potentialBi)) {
                        return false;
                    }

                    if (existingBi.getCount() + potentialBi.getCount() > existingBi.getMaxStackSize()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void process(ComponentProcessor pr, int procNumber) {
        if (pr.getRecipe(procNumber) == null) return;

        RedoxFurnaceRecipe locRecipe = (RedoxFurnaceRecipe) pr.getRecipe(procNumber);
        ComponentInventory inv = getComponent(IComponentType.Inventory);
        List<Integer> inputSlots = inv.getInputSlotsForProcessor(procNumber);
        List<CountableIngredient> recipeIngs = locRecipe.getCountedIngredients();

        for (CountableIngredient wrap : recipeIngs) {
            int amountToConsume = wrap.getStackSize();
            for (int slotIndex : inputSlots) {
                ItemStack stackInSlot = inv.getItem(slotIndex);

                if (!stackInSlot.isEmpty() && wrap.test(stackInSlot)) {
                    stackInSlot.shrink(amountToConsume);
                    inv.setItem(slotIndex, stackInSlot);
                    break;
                }
            }
        }

        if (locRecipe.hasItemBiproducts()) {
            List<ProbableItem> itemBi = locRecipe.getItemBiproducts();
            int index = 0;
            for (int slot : inv.getBiprodSlotsForProcessor(procNumber)) {
                if (index >= itemBi.size()) break;

                ItemStack rolledStack = itemBi.get(index).roll().copy();
                if (!rolledStack.isEmpty()) {
                    ItemStack currentStack = inv.getItem(slot);
                    if (currentStack.isEmpty()) {
                        inv.setItem(slot, rolledStack);
                    } else if (ItemStack.isSameItemSameComponents(currentStack, rolledStack)) {
                        currentStack.grow(rolledStack.getCount());
                        inv.setItem(slot, currentStack);
                    }
                }
                index++;
            }
        }

        int outputSlot = inv.getOutputSlots().get(procNumber);
        ItemStack recipeOutput = locRecipe.getItemRecipeOutput().copy();
        ItemStack currentOutput = inv.getItem(outputSlot);

        if (currentOutput.isEmpty()) {
            inv.setItem(outputSlot, recipeOutput);
        } else if (ItemStack.isSameItemSameComponents(currentOutput, recipeOutput)) {
            currentOutput.grow(recipeOutput.getCount());
            inv.setItem(outputSlot, currentOutput);
        }

        pr.dispenseExperience(inv, locRecipe.getXp());
        pr.setChanged();
    }

    public void tickClient(ComponentTickable tickable) {
        if (this.shouldPlaySound()) {
            if (this.level.random.nextDouble() < 0.15) {
                Direction direction = this.getFacing();
                double d4 = this.level.random.nextDouble();
                double d5 = direction.getAxis() == Direction.Axis.X ? (double)(direction.getStepX() * (direction.getStepX() == -1 ? 0 : 1)) : d4;
                double d6 = this.level.random.nextDouble();
                double d7 = direction.getAxis() == Direction.Axis.Z ? (double)(direction.getStepZ() * (direction.getStepZ() == -1 ? 0 : 1)) : d4;
                this.level.addParticle(ParticleTypes.LAVA, (double)this.worldPosition.getX() + getOffset(getFacing()).x + d5/2, (double)this.worldPosition.getY() + getOffset(getFacing()).y + d6/2, (double)this.worldPosition.getZ() + getOffset(getFacing()).z + d7/2, (double)0.0F, (double)0.0F, (double)0.0F);
                this.level.addParticle(ParticleTypes.LARGE_SMOKE, (double)this.worldPosition.getX() + getOffset(getFacing()).x + d5, (double)this.worldPosition.getY() + getOffset(getFacing()).y + d6, (double)this.worldPosition.getZ() + getOffset(getFacing()).z + d7, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            if (!this.isSoundPlaying) {
                this.isSoundPlaying = true;
                SoundBarrierMethods.playTileSound(ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
            }

        }
    }

    private static Vec3 getOffset(Direction facing) {
        return switch (facing) {
            case SOUTH -> new Vec3( -1, 3, -1);
            case WEST  -> new Vec3( -1, 3,  1);
            case EAST  -> new Vec3( 1, 3, -1);
            case NORTH -> new Vec3( 1, 3,  1);
            default -> Vec3.ZERO;
        };
    }

    @Override
    public void tickServer(ComponentTickable tickable) {
        super.tickServer(tickable);
    }

    @Override public @Nullable ICapabilityElectrodynamic getElectrodynamicCapability(@Nullable Direction side){ return null; }
    @Nullable @Override public ICapabilityElectrodynamic getSlaveCapabilityElectrodynamic(TileMultiblockSlave slave, @Nullable Direction side) {if (slave.index.getValue() != 1) {return null;}return this.<ComponentElectrodynamic>getComponent(IComponentType.Electrodynamic).getCapability(side, CapabilityInputType.NONE);}
    @Override public @Nullable IItemHandler getItemHandlerCapability(@Nullable Direction side){ return null; }

    @Override
    public ItemInteractionResult useWithItem(ItemStack used, Player player, InteractionHand hand, BlockHitResult hit) {
        if(!level.isClientSide() && hit.getBlockPos().equals(getBlockPos()) && used.getItem() instanceof IWrenchItem){
            checkFormed();
            if(isFormed.getValue()) formMultiblock(); else destroyMultiblock();
            return ItemInteractionResult.CONSUME;
        }
        return super.useWithItem(used, player, hand, hit);
    }

    @Override
    public InteractionResult useWithoutItem(Player player, BlockHitResult hit){ return isFormed.getValue() ? super.useWithoutItem(player, hit) : InteractionResult.FAIL; }

    @Override
    public void formMultiblock() {
        Direction facing = this.getFacing().getOpposite();
        List<MultiblockSlaveNode> nodes = Multiblock.getNodes(this.level, this.getResourceKey(), facing);
        int index = 0;

        for (MultiblockSlaveNode node : nodes) {
            BlockPos nodePos = this.getBlockPos().offset(node.offset());
            this.slavePositions.addValue(nodePos, index);

            BlockState placedState = node.placeState().setValue(VoltaicBlockStates.FACING, this.getFacing());
            this.level.setBlockAndUpdate(nodePos, placedState);

            TileMultiblockSlave slave = (TileMultiblockSlave) this.level.getBlockEntity(nodePos);
            if (slave != null) {
                BlockState disguise = node.replaceState();
                if (disguise != null) {
                    slave.setDisguise(disguise);
                } else {
                    slave.setDisguise(Blocks.AIR.defaultBlockState());
                }

                slave.controller.setValue(this.getBlockPos());
                slave.index.setValue(index);
                slave.renderModel.setValue(node.model());
                this.slaveList.add(slave);
            } else {
                ChemicalScience.LOGGER.warn("Failed to get TileMultiblockSlave at {}", nodePos);
            }

            ++index;
        }

        this.level.playSound((Player) null, this.getBlockPos(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    public void setNotPlaying() {
        this.isSoundPlaying = false;
    }

    public boolean shouldPlaySound() {
        return ((ComponentProcessor)this.getComponent(IComponentType.Processor)).isActive(0);
    }

    @Override public ResourceLocation getMultiblockId(){ return ID; }
    @Override public ResourceKey<Multiblock> getResourceKey(){ return RESOURCE_KEY; }
}
