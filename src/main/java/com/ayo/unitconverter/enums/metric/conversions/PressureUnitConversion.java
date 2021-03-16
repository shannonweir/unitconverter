package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;

/**
 * Enum Abbreviation Definitions:
 * <p>
 * B - Bar
 * P - Pascal
 * PSMI - Pound per Square Inch
 * SA - Standard Atmosphere
 * T - Torr
 */
public enum PressureUnitConversion implements UnaryOperator<Double> {

    /**
     * Bar Factor and Operation Type Mapping
     */
    B_B(1.0, Operator.MULTIPLY),
    B_P(100000.00, Operator.MULTIPLY),
    B_PPSI(14.504, Operator.MULTIPLY),
    B_SA(1.013, Operator.DIVIDE),
    B_T(750.00, Operator.MULTIPLY),

    /**
     * Pascal Factor and Operation Mapping
     */
    P_P(1.0, Operator.MULTIPLY),
    P_B(100000.00, Operator.DIVIDE),
    P_PPSI(6895.00, Operator.DIVIDE),
    P_SA(101325.00, Operator.DIVIDE),
    P_T(133.00, Operator.DIVIDE),

    /**
     * Pound per Square Inch Factor and Operator Mapping
     */
    PPSI_PPSI(1.0, Operator.MULTIPLY),
    PPSI_B(14.504, Operator.DIVIDE),
    PPSI_P(6895.00, Operator.MULTIPLY),
    PPSI_SA(14.696, Operator.DIVIDE),
    PPSI_T(51.715, Operator.MULTIPLY),

    /**
     * Standard Atmosphere Factor and Operator Mapping
     */
    SA_SA(1.0, Operator.MULTIPLY),
    SA_B(1.013, Operator.MULTIPLY),
    SA_P(101325.00, Operator.MULTIPLY),
    SA_PPSI(14.696, Operator.MULTIPLY),
    SA_T(760.0, Operator.MULTIPLY),

    /**
     * Torr Factor and Operator Mapping
     */
    T_T(1.0, Operator.DIVIDE),
    T_B(750.00, Operator.DIVIDE),
    T_P(133.00, Operator.MULTIPLY),
    T_PPSI(51.715, Operator.DIVIDE),
    T_SA(760.00, Operator.DIVIDE);

    private Double factor;
    private Operator operator;

    PressureUnitConversion(Double factor, Operator operator) {
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
