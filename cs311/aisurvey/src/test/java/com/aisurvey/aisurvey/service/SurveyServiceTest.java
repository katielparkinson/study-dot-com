// Testing
package com.aisurvey.aisurvey.service;

import com.aisurvey.aisurvey.model.SurveyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SurveyServiceTest {

    @Autowired
    private SurveyService surveyService;

    @Test
    @Sql(statements = "DELETE FROM survey_responses") // Clean the table before test
    void testSaveAndRetrieveSurveyResponse() {
        // Create a test response
        SurveyResponse response = new SurveyResponse();
        response.setName("Test User");
        response.setEmail("test@example.com");
        response.setQ1(1); // Strongly Agree
        response.setQ2(2); // Somewhat Agree
        response.setQ3(3); // Somewhat Disagree
        response.setQ4(4); // Strongly Disagree
        // Set remaining questions with varying responses
        response.setQ5(1);
        response.setQ6(2);
        response.setQ7(3);
        response.setQ8(4);
        response.setQ9(1);
        response.setQ10(2);
        response.setQ11(3);
        response.setQ12(4);
        response.setQ13(1);
        response.setQ14(2);
        response.setQ15(3);
        response.setQ16(4);
        response.setQ17(1);
        response.setQ18(2);
        response.setQ19(3);
    response.setQ20(2); // Center political alignment

        // Save the response
        surveyService.saveSurveyResponse(response);

        // Retrieve the response
        SurveyResponse retrieved = surveyService.getResponseByEmail("test@example.com");

        // Verify the data
        assertNotNull(retrieved);
        assertEquals("Test User", retrieved.getName());
        assertEquals("test@example.com", retrieved.getEmail());
        assertNotNull(retrieved.getCreatedAt()); // Should have been set by database
        
        // Verify all question responses
        assertEquals(1, retrieved.getQ1());
        assertEquals(2, retrieved.getQ2());
        assertEquals(3, retrieved.getQ3());
        assertEquals(4, retrieved.getQ4());
        assertEquals(1, retrieved.getQ5());
        assertEquals(2, retrieved.getQ6());
        assertEquals(3, retrieved.getQ7());
        assertEquals(4, retrieved.getQ8());
        assertEquals(1, retrieved.getQ9());
        assertEquals(2, retrieved.getQ10());
        assertEquals(3, retrieved.getQ11());
        assertEquals(4, retrieved.getQ12());
        assertEquals(1, retrieved.getQ13());
        assertEquals(2, retrieved.getQ14());
        assertEquals(3, retrieved.getQ15());
        assertEquals(4, retrieved.getQ16());
        assertEquals(1, retrieved.getQ17());
        assertEquals(2, retrieved.getQ18());
        assertEquals(3, retrieved.getQ19());
        assertEquals(2, retrieved.getQ20());
    }
}