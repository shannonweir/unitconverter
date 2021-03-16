package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;


/**
 * Enum Abbreviation Definitions:
 * <p>
 * H - Hertz
 * KH - KiloHertz
 * MH - MegaHertz
 * GH - GigaHertz
 */
public enum FrequencyUnitConversion implements UnaryOperator<Double> {

    /**
     * Hertz Factor and Operation Type Mapping
     */
    H_H(1.0, Operator.MULTIPLY),
    H_KH(1000.00, Operator.DIVIDE),
    H_MH(1e+6, Operator.DIVIDE),
    H_GH(1e+9, Operator.DIVIDE),

    /**
     * KiloHertz Factor and Operation Type Mapping
     */
    KH_KH(1.0, Operator.MULTIPLY),
    KH_H(1000.00, Operator.MULTIPLY),
    KH_MH(1000.00, Operator.DIVIDE),
    KH_GH(1e+6, Operator.DIVIDE),

    /**
     * MegaHertz Factor and Operation Type Mapping
     */
    MH_MH(1.0, Operator.MULTIPLY),
    MH_H(1e+6, Operator.MULTIPLY),
    MH_KH(1000.00, Operator.MULTIPLY),
    MH_GH(1000.00, Operator.DIVIDE),

    /**
     * GigaHertz Factor and Operation Type Mapping
     */
    GH_GH(1.0, Operator.MULTIPLY),
    GH_H(1e+9, Operator.MULTIPLY),
    GH_KH(1e+6, Operator.MULTIPLY),
    GH_MH(1000.00, Operator.MULTIPLY);

    private Double factor;
    private Operator operator;

    FrequencyUnitConversion(Double factor, Operator operator) {
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
