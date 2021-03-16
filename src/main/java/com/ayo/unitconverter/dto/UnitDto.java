package com.ayo.unitconverter.dto;

public class UnitDto {
    private String name;
    private String symbol;
    private MetricTypeDto metricType;

    public UnitDto() {
    }

    public UnitDto(String name, String symbol, MetricTypeDto metricTypeDto) {
        this.name = name;
        this.symbol = symbol;
        this.metricType = metricTypeDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public MetricTypeDto getMetricType() {
        return metricType;
    }

    public void setMetricType(MetricTypeDto metricType) {
        this.metricType = metricType;
    }
}
