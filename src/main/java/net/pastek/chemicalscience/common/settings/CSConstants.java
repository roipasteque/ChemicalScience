package net.pastek.chemicalscience.common.settings;

import voltaic.api.configuration.*;

@Configuration(name = "ChemicalScience")
public class CSConstants {

    @DoubleValue(def = 35.0)
    public static double ORGANICSOLARPANEL_AMPERAGE = 35.0;

    @DoubleValue(def = 550.0)
    public static double FUEL_CELL_JOULES_PER_TICK = 550.0;


}