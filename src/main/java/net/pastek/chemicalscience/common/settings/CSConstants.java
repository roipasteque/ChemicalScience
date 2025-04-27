package net.pastek.chemicalscience.common.settings;

import voltaic.api.configuration.*;

@Configuration(name = "ChemicalScience")
public class CSConstants {

    @DoubleValue(def = 35.0)
    public static double ORGANICSOLARPANEL_AMPERAGE = 35.0;

}