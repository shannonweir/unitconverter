package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;

/**
 * Enum Abbreviation Definitions:
 * <p>
 * SQKM - Square Kilometer
 * SQM - Square Meter
 * SQMI - Square Mile
 * SQY - Square Yard
 * SQF - Square Foot
 * SQI - Square Inch
 * H - Hectare
 * A - Acre
 */
public enum AreaUnitConversion implements UnaryOperator<Double> {

    /**
     * Square Kilometer Factor and Operation Type Mapping
     */
    SQKM_SQKM(1.0, Operator.MULTIPLY),
    SQKM_SQM(1e+6, Operator.MULTIPLY),
    SQKM_SQMI(2.59, Operator.DIVIDE),
    SQKM_SQY(1.196e+6, Operator.MULTIPLY),
    SQKM_SQF(1.076e+7, Operator.MULTIPLY),
    SQKM_SQI(1.55e+9, Operator.MULTIPLY),
    SQKM_H(100.00, Operator.MULTIPLY),
    SQKM_A(247.00, Operator.MULTIPLY),

    /**
     * Square Meter Factor and Operation Type Mapping
     */
    SQM_SQM(1.0, Operator.MULTIPLY),
    SQM_SQKM(1e+6, Operator.DIVIDE),
    SQM_SQMI(2.59e+6, Operator.DIVIDE),
    SQM_SQY(1.196, Operator.MULTIPLY),
    SQM_SQF(10.764, Operator.MULTIPLY),
    SQM_SQI(1550.00, Operator.MULTIPLY),
    SQM_H(10000.00, Operator.DIVIDE),
    SQM_A(4047.00, Operator.DIVIDE),

    /**
     * Square Mile Factor and Operation Type Mapping
     */
    SQMI_SQMI(1.0, Operator.MULTIPLY),
    SQMI_SQKM(2.59, Operator.MULTIPLY),
    SQMI_SQM(2.59e+6, Operator.MULTIPLY),
    SQMI_SQY(3.098e+6, Operator.MULTIPLY),
    SQMI_SQF(2.788e+7, Operator.MULTIPLY),
    SQMI_SQI(4.014e+9, Operator.MULTIPLY),
    SQMI_H(259.00, Operator.MULTIPLY),
    SQMI_A(640.00, Operator.MULTIPLY),

    /**
     * Square Yard Factor and Operation Type Mapping
     */
    SQY_SQY(1.0, Operator.MULTIPLY),
    SQY_SQKM(1.196e+6, Operator.DIVIDE),
    SQY_SQM(1.196, Operator.DIVIDE),
    SQY_SQMI(3.098e+6, Operator.DIVIDE),
    SQY_SQF(9.0, Operator.MULTIPLY),
    SQY_SQI(1296.00, Operator.MULTIPLY),
    SQY_H(11960.00, Operator.DIVIDE),
    SQY_A(4840.00, Operator.DIVIDE),

    /**
     * Square Foot Factor and Operation Type Mapping
     */
    SQF_SQF(1.0, Operator.MULTIPLY),
    SQF_SQKM(1.076e+7, Operator.DIVIDE),
    SQF_SQM(10.764, Operator.DIVIDE),
    SQF_SQMI(2.788e+7, Operator.DIVIDE),
    SQF_SQY(9.0, Operator.DIVIDE),
    SQF_SQI(144.00, Operator.MULTIPLY),
    SQF_H(107639.00, Operator.DIVIDE),
    SQF_A(43560.00, Operator.DIVIDE),

    /**
     * Square Inch Factor and Operation Type Mapping
     */
    SQI_SQI(1.0, Operator.MULTIPLY),
    SQI_SQKM(1.55e+9, Operator.DIVIDE),
    SQI_SQM(1550.00, Operator.DIVIDE),
    SQI_SQMI(4.014e+9, Operator.DIVIDE),
    SQI_SQY(1296.00, Operator.DIVIDE),
    SQI_SQF(144.00, Operator.DIVIDE),
    SQI_H(1.55e+7, Operator.DIVIDE),
    SQI_A(6.273e+6, Operator.DIVIDE),

    /**
     * Hectare Factor and Operation Type Mapping
     */
    H_H(1.0, Operator.MULTIPLY),
    H_SQKM(100.00, Operator.DIVIDE),
    H_SQM(10000.00, Operator.MULTIPLY),
    H_SQMI(259.00, Operator.DIVIDE),
    H_SQY(11960.00, Operator.MULTIPLY),
    H_SQF(107639.00, Operator.MULTIPLY),
    H_SQI(1.55e+7, Operator.MULTIPLY),
    H_A(2.471, Operator.MULTIPLY),

    /**
     * Acre Factor and Operation Type Mapping
     */
    A_A(1.0, Operator.MULTIPLY),
    A_SQKM(247.00, Operator.DIVIDE),
    A_SQM(4047.00, Operator.MULTIPLY),
    A_SQMI(640.00, Operator.DIVIDE),
    A_SQY(4840.00, Operator.MULTIPLY),
    A_SQF(43560.00, Operator.MULTIPLY),
    A_SQI(6.273e+6, Operator.MULTIPLY),
    A_H(2.471, Operator.DIVIDE);

    private Double factor;
    private Operator operator;

    AreaUnitConversion(Double factor, Operator operator) {
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


