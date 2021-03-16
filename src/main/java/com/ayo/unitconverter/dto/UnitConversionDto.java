package com.ayo.unitconverter.dto;

public class UnitConversionDto {
    private String unitConversion;
    private Double measurement;
    private Double result;
    private MetricTypeDto metricType;

    public String getUnitConversion() {
        return unitConversion;
    }

    public void setUnitConversion(String unitConversion) {
        this.unitConversion = unitConversion;
    }

    public Double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Double measurement) {
        this.measurement = measurement;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public MetricTypeDto getMetricType() {
        return metricType;
    }

    public void setMetricType(MetricTypeDto metricType) {
        this.metricType = metricType;
    }
}
