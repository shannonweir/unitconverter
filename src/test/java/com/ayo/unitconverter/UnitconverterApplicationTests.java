package com.ayo.unitconverter;

import com.ayo.unitconverter.enums.MetricType;
import com.ayo.unitconverter.strategy.UnitConversionCalculationStrategy;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UnitconverterApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UnitConversionCalculationStrategy unitConversionCalculationStrategy;

    @Test
    public void shouldReturnAllMetricTypesTest() throws Exception {
        mvc.perform(get("/ayo/api/metric/types")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$[0].symbol").value("T"))
                .andExpect(jsonPath("$[1].symbol").value("P"))
                .andExpect(jsonPath("$[2].symbol").value("F"))
                .andExpect(jsonPath("$[3].symbol").value("S"))
                .andExpect(jsonPath("$[4].symbol").value("A"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldReturnAllUnitsBySpeedMetricTypeTest() throws Exception {
        mvc.perform(get("/ayo/api/metric/units")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("metricType", "SPEED"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].name").value("Mile per Hour"))
                .andExpect(jsonPath("$[1].name").value("Foot per Second"))
                .andExpect(jsonPath("$[2].name").value("Meter per Second"))
                .andExpect(jsonPath("$[3].name").value("Kilometer per Hour"))
                .andExpect(jsonPath("$[4].name").value("Knot"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldReturn212AsResultAfterTemperatureConversionTest() throws Exception {
        mvc.perform(post("/ayo/api/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("measurement", "100.00")
                .queryParam("unitConversion", "C_F")
                .queryParam("metricType", MetricType.TEMPERATURE.name()))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(212))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void calculateKmToMile() {
        Double km_mile = unitConversionCalculationStrategy.calculate(MetricType.LENGTH, "KM_MILE", 900.00);
        assertThat(km_mile).isEqualTo(559.3536357986327);
    }
}
