package net.pastek.chemicalscience.common.block;


import net.pastek.chemicalscience.common.block.facing.FacingDirection;
import net.pastek.chemicalscience.common.block.facing.FacingDirectionProperty;

public class CSBlockStates {

    public static void init() {

    }

    public static final FacingDirectionProperty FACINGDIRECTION = FacingDirectionProperty.create("side", FacingDirection.values());

}