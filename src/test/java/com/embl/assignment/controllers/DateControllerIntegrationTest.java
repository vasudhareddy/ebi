package com.embl.assignment.controllers;

import com.embl.assignment.*;
import com.embl.assignment.model.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;
import org.springframework.boot.web.server.*;

import java.time.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AssignmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DateControllerIntegrationTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    ZonedDateTime time;
    @LocalServerPort
    private int port;


    @BeforeEach
    public void setUp() {
        time  = ZonedDateTime.now();
    }

    @Test
    @DisplayName("This test check date response is returned")
    public void test_fetchDate() {
        DateResponse response = this.restTemplate.getForObject("http://localhost:" + port + "/ebi/date", DateResponse.class);
        int year = time.getYear();
        assertThat(response).isNotNull();
        assertTrue(response.getDate().contains(String.valueOf(year)));
    }

}
