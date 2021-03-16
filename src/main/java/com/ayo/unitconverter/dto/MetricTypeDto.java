package com.ayo.unitconverter.dto;

public class MetricTypeDto {
    private String symbol;
    private String name;

    public MetricTypeDto() {
    }

    public MetricTypeDto(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
