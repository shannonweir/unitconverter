package com.ayo.unitconverter.strategy;

import com.ayo.unitconverter.enums.MetricType;

public interface UnitConversionCalculationStrategy {

    Double calculate(MetricType metricType, String unitConversion, Double aDouble);
}
