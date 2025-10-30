package com.aisurvey.aisurvey.controller;

import com.aisurvey.aisurvey.model.SurveyResponse;
import com.aisurvey.aisurvey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitSurvey(SurveyResponse surveyResponse) {
        try {
            surveyService.saveSurveyResponse(surveyResponse);
            return ResponseEntity.ok("Thank you for your submission, " + surveyResponse.getName() + "!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error saving your response: " + e.getMessage());
        }
    }
}
//