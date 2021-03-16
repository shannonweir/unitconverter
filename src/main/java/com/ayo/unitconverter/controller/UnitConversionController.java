package com.ayo.unitconverter.controller;

import com.ayo.unitconverter.dto.MetricTypeDto;
import com.ayo.unitconverter.dto.UnitConversionDto;
import com.ayo.unitconverter.dto.UnitDto;
import com.ayo.unitconverter.enums.MetricType;
import com.ayo.unitconverter.service.UnitConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ayo/api")
public class UnitConversionController {

    @Autowired
    private UnitConversionService unitConversionService;

    @GetMapping(value = "/metric/types", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MetricTypeDto>> getAllMetricTypes() {
        return new ResponseEntity<>(unitConversionService.getAllMetricTypes(), HttpStatus.OK);
    }

    @GetMapping(value = "/metric/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UnitDto>> getAllUnitsByMetricType(@RequestParam("metricType") MetricType metricType) {
        return new ResponseEntity<>(unitConversionService.getAllUnitsByMetricType(metricType), HttpStatus.OK);
    }

    @PostMapping(value = "/convert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitConversionDto> convert(@RequestParam("measurement") Double measurement, @RequestParam("metricType") MetricType metricType, @RequestParam("unitConversion") String unitConversion) {
        return new ResponseEntity<>(unitConversionService.convert(measurement, metricType, unitConversion), HttpStatus.CREATED);
    }
}
