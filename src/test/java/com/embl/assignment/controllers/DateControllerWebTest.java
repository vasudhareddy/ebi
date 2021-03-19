package com.embl.assignment.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.web.servlet.*;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(DateController.class)
@AutoConfigureMockMvc
public class DateControllerWebTest {

    ZonedDateTime time;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        time  = ZonedDateTime.now();
    }

    @Test
    @DisplayName("This test check date response is returned")
    public void test_fetchDate() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/date")).andReturn();
        String output = result.getResponse().getContentAsString();
        int year = time.getYear();
        assertThat(output).isNotNull();
        assertTrue(output.contains(String.valueOf(year)));

    }
}
