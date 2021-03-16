package com.ayo.unitconverter.enums.metric.conversions;

import com.ayo.unitconverter.enums.Operator;
import com.ayo.unitconverter.utils.ConverterUtils;

import java.util.function.UnaryOperator;

/**
 * Enum Abbreviation Definitions:
 * <p>
 * C - Celsius
 * K - Kelvin
 * F - Fahrenheit
 */
public enum TemperatureUnitConversion implements UnaryOperator<Double> {

    /**
     * Celcius conversion Operation using a certain Formula's and
     * Factor and Operation Type Mapping
     */
    C_C(1.0, Operator.MULTIPLY),
    C_F() {
        @Override
        public Double apply(Double aDouble) {
            return (aDouble * 9 / 5) + 32;

        }
    },
    C_K(273.15, Operator.PLUS),

    /**
     * Fahrenheit conversion Operation using a certain Formula's and
     * Factor and Operation Type Mapping
     */
    F_F(1.0, Operator.MULTIPLY),
    F_C() {
        @Override
        public Double apply(Double aDouble) {
            return (aDouble - 32) * 5 / 9;
        }
    },
    F_K() {
        @Override
        public Double apply(Double aDouble) {
            return (aDouble - 32) * 5 / 9 + 273.15;
        }
    },

    /**
     * Kelvin conversion Operation using a certain Formula's and
     * Factor and Operation Type Mapping
     */
    K_K(1.0, Operator.MULTIPLY),
    K_C(273.15, Operator.MINUS),
    K_F() {
        @Override
        public Double apply(Double aDouble) {
            return (aDouble - 273.15) * 9 / 5 + 32;
        }
    };

    private Double factor;
    private Operator operator;

    TemperatureUnitConversion() {
    }

    TemperatureUnitConversion(Double factor, Operator operator) {
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
