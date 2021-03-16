package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;

/**
 * Enum Abbreviation Definitions:
 * <p>
 * T - Tonne
 * KG - Kilograms
 * G - Gram
 * IMT - Imperial Ton
 * UST - US Ton
 * ST - Stone
 * PD - Pound
 * O - Ounce
 */
public enum MassUnitConversion implements UnaryOperator<Double> {

    /**
     * Tonne Factor and Operation Type Mapping
     */
    T_T(1.0, Operator.MULTIPLY),
    T_KG(1000.00, Operator.MULTIPLY),
    T_G(1e+6, Operator.MULTIPLY),
    T_IMT(1.016, Operator.DIVIDE),
    T_UST(1.102, Operator.MULTIPLY),
    T_ST(157.00, Operator.MULTIPLY),
    T_PD(2205.00, Operator.MULTIPLY),
    T_O(35274.00, Operator.MULTIPLY),

    /**
     * Kilogram Factor and Operation Type Mapping
     */
    KG_KM(1.0, Operator.MULTIPLY),
    KG_T(1000.00, Operator.DIVIDE),
    KG_G(1000.00, Operator.MULTIPLY),
    KG_IMT(1016.00, Operator.MULTIPLY),
    KG_UST(907.00, Operator.DIVIDE),
    KG_ST(6.35, Operator.DIVIDE),
    KG_PD(2.205, Operator.MULTIPLY),
    KG_O(35.274, Operator.MULTIPLY),

    /**
     * Gram Factor and Operation Type Mapping
     */
    G_G(1.0, Operator.MULTIPLY),
    G_T(1e+6, Operator.DIVIDE),
    G_KG(1000.00, Operator.DIVIDE),
    G_IMT(1.016e+6, Operator.DIVIDE),
    G_UST(907185.00, Operator.DIVIDE),
    G_ST(6350.00, Operator.DIVIDE),
    G_PD(454.00, Operator.DIVIDE),
    G_O(28.35, Operator.DIVIDE),

    /**
     * Imperial Ton Factor and Operation Type Mapping
     */
    IMT_IMT(1.0, Operator.MULTIPLY),
    IMT_T(1.016, Operator.MULTIPLY),
    IMT_KG(1016.00, Operator.MULTIPLY),
    IMT_G(1.016e+6, Operator.MULTIPLY),
    IMT_UST(1.12, Operator.MULTIPLY),
    IMT_ST(160.00, Operator.MULTIPLY),
    IMT_PD(2240.00, Operator.MULTIPLY),
    IMT_O(35840.00, Operator.MULTIPLY),

    /**
     * US Ton Factor and Operation Type Mapping
     */
    UST_UST(1.0, Operator.MULTIPLY),
    UST_T(1.102, Operator.DIVIDE),
    UST_KG(907.00, Operator.MULTIPLY),
    UST_G(907185.00, Operator.MULTIPLY),
    UST_IMT(1.12, Operator.DIVIDE),
    UST_ST(143.00, Operator.MULTIPLY),
    UST_PD(2000.00, Operator.MULTIPLY),
    UST_O(32000.00, Operator.MULTIPLY),

    /**
     * Stone Factor and Operation Type Mapping
     */
    ST_ST(1.0, Operator.MULTIPLY),
    ST_T(157.00, Operator.DIVIDE),
    ST_KG(6.35, Operator.MULTIPLY),
    ST_G(6350.00, Operator.MULTIPLY),
    ST_IMT(160.00, Operator.DIVIDE),
    ST_UST(143.00, Operator.DIVIDE),
    ST_PD(14.0, Operator.MULTIPLY),
    ST_O(224.00, Operator.MULTIPLY),

    /**
     * Pound Factor and Operation Type Mapping
     */
    PD_PD(1.0, Operator.MULTIPLY),
    PD_T(2205.00, Operator.DIVIDE),
    PD_KG(2.205, Operator.DIVIDE),
    PD_G(454.00, Operator.MULTIPLY),
    PD_IMT(2240.00, Operator.DIVIDE),
    PD_UST(2000.00, Operator.DIVIDE),
    PD_ST(14.00, Operator.DIVIDE),
    PD_O(16.0, Operator.MULTIPLY),

    /**
     * Ounce Factor and Operation Type Mapping
     */
    O_O(1.0, Operator.MULTIPLY),
    O_T(35274.00, Operator.DIVIDE),
    O_KG(35.274, Operator.DIVIDE),
    O_G(28.35, Operator.MULTIPLY),
    O_IMT(35840.00, Operator.DIVIDE),
    O_UST(32000.00, Operator.DIVIDE),
    O_ST(224.00, Operator.DIVIDE),
    O_PD(16.0, Operator.DIVIDE);

    private Double factor;
    private Operator operator;

    MassUnitConversion(Double factor, Operator operator) {
        this.factor = factor;
        this.operator = operator;
    }

    public Double getFactor() {
        return factor;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public Double apply(Double aDouble) {
        return ConverterUtils.apply(aDouble, this.getOperator(), this.getFactor());
    }
}
