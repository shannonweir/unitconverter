package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;

/**
 * Enum Abbreviation Definitions:
 * <p>
 * KM - Kilometer
 * M - Meter
 * CM - Centimeter
 * MM - Millimeter
 * MILE - Mile
 * Y - Yard
 * F - Foot
 * I - Inch
 */
public enum LengthUnitConversion implements UnaryOperator<Double> {

    /**
     * Kilometer Factor and Operation Type Mapping
     */
    KM_KM(1.0, Operator.MULTIPLY),
    KM_M(1000.00, Operator.MULTIPLY),
    KM_CM(100000.00, Operator.MULTIPLY),
    KM_MM(1e+6, Operator.MULTIPLY),
    KM_MILE(1.609, Operator.DIVIDE),
    KM_Y(1094.00, Operator.MULTIPLY),
    KM_F(3281.00, Operator.MULTIPLY),
    KM_I(39370.00, Operator.MULTIPLY),

    /**
     * Meter Factor and Operation Type Mapping
     */
    M_M(1.0, Operator.MULTIPLY),
    M_KM(1000.00, Operator.DIVIDE),
    M_CM(100.00, Operator.MULTIPLY),
    M_MM(1000.00, Operator.MULTIPLY),
    M_MILE(1609.00, Operator.DIVIDE),
    M_Y(1.094, Operator.MULTIPLY),
    M_F(3.281, Operator.MULTIPLY),
    M_I(39.37, Operator.MULTIPLY),

    /**
     * Centimeter Factor and Operation Type Mapping
     */
    CM_CM(1.0, Operator.MULTIPLY),
    CM_KM(100000.00, Operator.DIVIDE),
    CM_M(100.00, Operator.DIVIDE),
    CM_MM(10.0, Operator.MULTIPLY),
    CM_MILE(160934.00, Operator.DIVIDE),
    CM_Y(91.44, Operator.DIVIDE),
    CM_F(30.48, Operator.DIVIDE),
    CM_I(2.54, Operator.DIVIDE),

    /**
     * Millimeter Factor and Operation Type Mapping
     */
    MM_MM(1.0, Operator.MULTIPLY),
    MM_KM(1e+6, Operator.DIVIDE),
    MM_M(1000.00, Operator.DIVIDE),
    MM_CM(10.0, Operator.DIVIDE),
    MM_MILE(1.609e+6, Operator.DIVIDE),
    MM_Y(914.00, Operator.DIVIDE),
    MM_F(305.00, Operator.DIVIDE),
    MM_I(25.4, Operator.DIVIDE),

    /**
     * Mile Factor and Operation Type Mapping
     */
    MILE_MILE(1.0, Operator.MULTIPLY),
    MILE_KM(1.609, Operator.MULTIPLY),
    MILE_M(1609.00, Operator.MULTIPLY),
    MILE_CM(160934.00, Operator.MULTIPLY),
    MILE_MM(1.609e+6, Operator.MULTIPLY),
    MILE_Y(1760.00, Operator.MULTIPLY),
    MILE_F(5280.00, Operator.MULTIPLY),
    MILE_I(63360.00, Operator.MULTIPLY),

    /**
     * Yard Factor and Operation Type Mapping
     */
    Y_Y(1.0, Operator.MULTIPLY),
    Y_KM(1094.00, Operator.DIVIDE),
    Y_M(1.094, Operator.DIVIDE),
    Y_CM(91.44, Operator.MULTIPLY),
    Y_MM(914.00, Operator.MULTIPLY),
    Y_MILE(1760.00, Operator.DIVIDE),
    Y_F(3.0, Operator.MULTIPLY),
    Y_I(36.0, Operator.MULTIPLY),

    /**
     * Inch Factor and Operation Type Mapping
     */
    I_I(1.0, Operator.MULTIPLY),
    I_KM(39370.00, Operator.DIVIDE),
    I_M(39.37, Operator.DIVIDE),
    I_CM(2.54, Operator.MULTIPLY),
    I_MM(25.4, Operator.MULTIPLY),
    I_MILE(63360.00, Operator.DIVIDE),
    I_Y(36.0, Operator.DIVIDE),
    I_F(12.00, Operator.DIVIDE);

    private Double factor;
    private Operator operator;

    LengthUnitConversion(Double factor, Operator operator) {
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
