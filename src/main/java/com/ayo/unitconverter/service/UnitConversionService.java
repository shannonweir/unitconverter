package com.ayo.unitconverter.service;

import com.ayo.unitconverter.dto.MetricTypeDto;
import com.ayo.unitconverter.dto.UnitConversionDto;
import com.ayo.unitconverter.dto.UnitDto;
import com.ayo.unitconverter.enums.MetricType;

import java.util.List;

public interface UnitConversionService {

    List<MetricTypeDto> getAllMetricTypes();

    List<UnitDto> getAllUnitsByMetricType(MetricType metricType);

    UnitConversionDto convert(double measurement, MetricType metricType, String unitConversion);
}
