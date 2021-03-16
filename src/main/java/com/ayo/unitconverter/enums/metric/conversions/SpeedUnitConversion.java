package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;

/**
 * Enum Abbreviation Definitions:
 * <p>
 * MPS - Miles per Hour
 * FPS - Foot per Second
 * MPS - Meter per Second
 * KMPH - Kilometer per Hour
 * KN - Knot
 */
public enum SpeedUnitConversion implements UnaryOperator<Double> {

    /**
     * Miles per Hour Factor and Operation Type Mapping
     */
    MPH_MPH(1.0, Operator.MULTIPLY),
    MPH_FPS(1.467, Operator.MULTIPLY),
    MPH_MPS(2.237, Operator.DIVIDE),
    MPH_KMPH(1.609, Operator.MULTIPLY),
    MPH_KN(1.151, Operator.DIVIDE),

    /**
     * Foot per Second Factor and Operation Type Mapping
     */
    FPS_FPS(1.0, Operator.MULTIPLY),
    FPS_MPH(1.467, Operator.DIVIDE),
    FPS_MPS(3.281, Operator.DIVIDE),
    FPS_KMPH(1.097, Operator.MULTIPLY),
    FPS_KN(1.688, Operator.DIVIDE),

    /**
     * Meter per Second Factor and Operation Type Mapping
     */
    MPS_MPS(1.0, Operator.MULTIPLY),
    MPS_MPH(2.237, Operator.MULTIPLY),
    MPS_FPS(3.281, Operator.MULTIPLY),
    MPS_KMPH(3.6, Operator.MULTIPLY),
    MPS_KN(1.944, Operator.MULTIPLY),

    /**
     * Kilometer per Hour Factor and Operation Type Mapping
     */
    KMPH_KMPH(1.0, Operator.MULTIPLY),
    KMPH_MPH(1.609, Operator.DIVIDE),
    KMPH_FPS(1.097, Operator.DIVIDE),
    KMPH_MPS(3.6, Operator.DIVIDE),
    KMPH_KN(1.852, Operator.DIVIDE),

    /**
     * Knot Factor and Operation Type Mapping
     */
    KN_KN(1.0, Operator.MULTIPLY),
    KN_MPH(1.151, Operator.MULTIPLY),
    KN_FPS(1.688, Operator.MULTIPLY),
    KN_MPS(1.944, Operator.DIVIDE),
    KN_KMPH(1.852, Operator.MULTIPLY);

    private Double factor;
    private Operator operator;

    SpeedUnitConversion(Double factor, Operator operator) {
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
