package com.ayo.unitconverter.strategy.impl;

import com.ayo.unitconverter.enums.MetricType;
import com.ayo.unitconverter.enums.metric.conversions.*;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UnitConversionCalculationStrategy implements com.ayo.unitconverter.strategy.UnitConversionCalculationStrategy {

    @Override
    public Double calculate(MetricType metricType, String unitConversion, Double aDouble) {
        switch (metricType) {
            case AREA:
                if (!EnumUtils.isValidEnum(AreaUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Area Metric include: " + Arrays.toString(AreaUnitConversion.values()));
                }
                AreaUnitConversion areaUnitConversion = AreaUnitConversion.valueOf(unitConversion);
                return areaUnitConversion.apply(aDouble);
            case SPEED:
                if (!EnumUtils.isValidEnum(SpeedUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Speed Metric include: " + Arrays.toString(SpeedUnitConversion.values()));
                }
                SpeedUnitConversion speedUnitConversion = SpeedUnitConversion.valueOf(unitConversion);
                return speedUnitConversion.apply(aDouble);
            case FREQUENCY:
                if (!EnumUtils.isValidEnum(FrequencyUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Frequency Metric include: " + Arrays.toString(FrequencyUnitConversion.values()));
                }
                FrequencyUnitConversion frequencyUnitConversion = FrequencyUnitConversion.valueOf(unitConversion);
                return frequencyUnitConversion.apply(aDouble);
            case PRESSURE:
                if (!EnumUtils.isValidEnum(PressureUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Pressure Metric include: " + Arrays.toString(PressureUnitConversion.values()));
                }
                PressureUnitConversion pressureUnitConversion = PressureUnitConversion.valueOf(unitConversion);
                return pressureUnitConversion.apply(aDouble);
            case TEMPERATURE:
                if (!EnumUtils.isValidEnum(TemperatureUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Temperature Metric include: " + Arrays.toString(TemperatureUnitConversion.values()));
                }
                TemperatureUnitConversion temperatureUnitConversion = TemperatureUnitConversion.valueOf(unitConversion);
                return temperatureUnitConversion.apply(aDouble);
            case LENGTH:
                if (!EnumUtils.isValidEnum(LengthUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Length Metric include: " + Arrays.toString(LengthUnitConversion.values()));
                }
                LengthUnitConversion lengthUnitConversion = LengthUnitConversion.valueOf(unitConversion);
                return lengthUnitConversion.apply(aDouble);
            case MASS:
                if (!EnumUtils.isValidEnum(MassUnitConversion.class, unitConversion)) {
                    throw new IllegalArgumentException("Unit Conversion Symbol is invalid. Unit Conversion Symbol: " + unitConversion + ". Valid Unit Conversion Symbols for Mass Metric include: " + Arrays.toString(MassUnitConversion.values()));
                }
                MassUnitConversion massUnitConversion = MassUnitConversion.valueOf(unitConversion);
                return massUnitConversion.apply(aDouble);
            default:
                throw new IllegalArgumentException("Metric Type is invalid or not supported: " + metricType);
        }
    }
}
