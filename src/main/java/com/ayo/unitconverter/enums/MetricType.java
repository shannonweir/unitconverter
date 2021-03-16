package com.ayo.unitconverter.enums;

public enum MetricType {
    TEMPERATURE("T", "Temperature"),
    PRESSURE("P", "Pressure"),
    FREQUENCY("F", "Frequency"),
    SPEED("S", "Speed"),
    AREA("A", "Area"),
    LENGTH("L", "Length"),
    MASS("M", "Mass");

    private String symbol;
    private String metricName;

    MetricType(String symbol, String metricName) {
        this.symbol = symbol;
        this.metricName = metricName;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMetricName() {
        return metricName;
    }
}
