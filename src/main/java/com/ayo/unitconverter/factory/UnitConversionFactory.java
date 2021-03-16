package com.ayo.unitconverter.factory;

import com.ayo.unitconverter.dto.MetricTypeDto;
import com.ayo.unitconverter.dto.UnitDto;
import com.ayo.unitconverter.enums.MetricType;
import com.ayo.unitconverter.enums.metric.unit.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitConversionFactory {

    public MetricTypeDto createMetricDto(MetricType metricType) {
        MetricTypeDto metricTypeDto = new MetricTypeDto();
        metricTypeDto.setName(metricType.getMetricName());
        metricTypeDto.setSymbol(metricType.getSymbol());
        return metricTypeDto;
    }

    public UnitDto createUnitDto(Unit unit) {
        UnitDto unitDto = new UnitDto();
        unitDto.setName(unit.getUnitName());
        unitDto.setSymbol(unit.getSymbol());
        unitDto.setMetricType(createMetricDto(unit.getMetricType()));
        return unitDto;
    }
}
