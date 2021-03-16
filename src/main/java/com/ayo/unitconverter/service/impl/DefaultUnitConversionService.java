package com.ayo.unitconverter.service.impl;

import com.ayo.unitconverter.dto.MetricTypeDto;
import com.ayo.unitconverter.dto.UnitConversionDto;
import com.ayo.unitconverter.dto.UnitDto;
import com.ayo.unitconverter.enums.MetricType;
import com.ayo.unitconverter.enums.metric.unit.Unit;
import com.ayo.unitconverter.factory.UnitConversionFactory;
import com.ayo.unitconverter.service.UnitConversionService;
import com.ayo.unitconverter.strategy.UnitConversionCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUnitConversionService implements UnitConversionService {

    @Autowired
    private UnitConversionFactory unitConversionFactory;

    @Autowired
    private UnitConversionCalculationStrategy unitConversionCalculationStrategy;

    @Override
    public List<MetricTypeDto> getAllMetricTypes() {
        return Arrays.stream(MetricType.values())
                .map(metricType -> unitConversionFactory.createMetricDto(metricType))
                .collect(Collectors.toList());
    }

    @Override
    public List<UnitDto> getAllUnitsByMetricType(MetricType metricType) {
        return Arrays.stream(Unit.values())
                .filter(unit -> unit.getMetricType().equals(metricType))
                .map(unit -> unitConversionFactory.createUnitDto(unit))
                .collect(Collectors.toList());
    }

    @Override
    public UnitConversionDto convert(double measurement, MetricType metricType, String unitConversion) {
        UnitConversionDto unitConversionDto = new UnitConversionDto();
        unitConversionDto.setUnitConversion(unitConversion);
        unitConversionDto.setMeasurement(measurement);
        unitConversionDto.setMetricType(unitConversionFactory.createMetricDto(metricType));
        unitConversionDto.setResult(unitConversionCalculationStrategy.calculate(metricType, unitConversion, measurement));
        return unitConversionDto;
    }
}


