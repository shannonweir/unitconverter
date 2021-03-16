package com.ayo.unitconverter.utils;

import com.ayo.unitconverter.enums.Operator;

import java.util.function.DoubleBinaryOperator;

public final class ConverterUtils {

    public static Double apply(Double aDouble, Operator operator, Double factor) {
        switch (operator) {
            case MULTIPLY:
                return compute((a, b) -> a * b, aDouble, factor);
            case DIVIDE:
                return compute((a, b) -> a / b, aDouble, factor);
            case PLUS:
                return compute((a, b) -> a + b, aDouble, factor);
            case MINUS:
                return compute((a, b) -> a - b, aDouble, factor);
            default:
                throw new IllegalArgumentException("Incorrect or unsupported operator: " + operator);
        }
    }

    private static Double compute(DoubleBinaryOperator operator, Double operand1, Double operand2) {
        return operator.applyAsDouble(operand1, operand2);
    }
}
