package com.ayo.unitconverter.enums.metric.unit;

import com.ayo.unitconverter.enums.MetricType;

public enum Unit {

    SQUARE_KILOMETER("SQKM", "Square Kilometer", MetricType.AREA),
    SQUARE_METER("SQM", "Square Meter", MetricType.AREA),
    SQUARE_MILE("SQMI", "Square Mile", MetricType.AREA),
    SQUARE_YARD("SQY", "Square Yard", MetricType.AREA),
    SQUARE_FOOT("SQF", "Square Foot", MetricType.AREA),
    SQUARE_INCH("SQI", "Square Inch", MetricType.AREA),
    HECTARE("H", "Hectare", MetricType.AREA),
    ACRE("A", "Acre", MetricType.AREA),

    HERTZ("H", "Hertz", MetricType.FREQUENCY),
    KILOHERTZ("KH", "Kilohertz", MetricType.FREQUENCY),
    MEGAHERTZ("MH", "Megahertz", MetricType.FREQUENCY),
    GIGAHERTZ("GH", "GigaHertz", MetricType.FREQUENCY),

    BAR("B", "Bar", MetricType.PRESSURE),
    PASCAL("P", "Pascal", MetricType.PRESSURE),
    POUND_PER_SQUARE_INCH("PPSI", "Pound per Square Inch", MetricType.PRESSURE),
    STANDARD_ATMOSPHERE("SA", "Standard Atmosphere", MetricType.PRESSURE),
    TORR("T", "Torr", MetricType.PRESSURE),

    MILE_PER_HOUR("MPH", "Mile per Hour", MetricType.SPEED),
    FOOT_PER_SECOND("FPS", "Foot per Second", MetricType.SPEED),
    METER_PER_SECOND("MPS", "Meter per Second", MetricType.SPEED),
    KILOMETER_PER_HOUR("KMPH", "Kilometer per Hour", MetricType.SPEED),
    KNOT("KN", "Knot", MetricType.SPEED),

    CELCIUS("C", "Celcius", MetricType.TEMPERATURE),
    FAHRENHEIT("F", "Fahrenheit", MetricType.TEMPERATURE),
    KELVIN("K", "Kelvin", MetricType.TEMPERATURE),

    KILOMETER("KM", "Kilometer", MetricType.LENGTH),
    METER("M", "Meter", MetricType.LENGTH),
    CENTIMETER("CM", "Centimeter", MetricType.LENGTH),
    MILLIMETER("MM", "Millimeter", MetricType.LENGTH),
    MILE("MILE", "Mile", MetricType.LENGTH),
    YARD("Y", "Yard", MetricType.LENGTH),
    FOOT("F", "Foot", MetricType.LENGTH),
    INCH("I", "Inch", MetricType.LENGTH),

    TONNE("T", "Tonne", MetricType.MASS),
    KILOGRAM("KG", "Kilogram", MetricType.MASS),
    GRAM("G", "Gram", MetricType.MASS),
    IMPERIAL_TON("IMT", "Imperial Ton", MetricType.MASS),
    US_TON("UST", "US Ton", MetricType.MASS),
    STONE("ST", "Stone", MetricType.MASS),
    POUND("PD", "Pound", MetricType.MASS),
    OUNCE("O", "Ounce", MetricType.MASS);

    private String symbol;
    private String unitName;
    private MetricType metricType;

    Unit(String symbol, String unitName, MetricType metricType) {
        this.symbol = symbol;
        this.unitName = unitName;
        this.metricType = metricType;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getUnitName() {
        return unitName;
    }
}
