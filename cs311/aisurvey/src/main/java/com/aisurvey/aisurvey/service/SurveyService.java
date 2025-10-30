package com.aisurvey.aisurvey.service;

import com.aisurvey.aisurvey.model.SurveyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SurveyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveSurveyResponse(SurveyResponse response) {
        String sql = "INSERT INTO survey_responses (name, email, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            response.getName(),
            response.getEmail(),
            response.getQ1(),
            response.getQ2(),
            response.getQ3(),
            response.getQ4(),
            response.getQ5(),
            response.getQ6(),
            response.getQ7(),
            response.getQ8(),
            response.getQ9(),
            response.getQ10(),
            response.getQ11(),
            response.getQ12(),
            response.getQ13(),
            response.getQ14(),
            response.getQ15(),
            response.getQ16(),
            response.getQ17(),
            response.getQ18(),
            response.getQ19(),
            response.getQ20()
        );
    }

    public SurveyResponse getResponseByEmail(String email) {
        String sql = "SELECT name, email, created_at, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20 FROM survey_responses WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            SurveyResponse response = new SurveyResponse();
            response.setName(rs.getString("name"));
            response.setEmail(rs.getString("email"));
            response.setCreatedAt(rs.getString("created_at"));
            response.setQ1(getNullableInt(rs, "q1"));
            response.setQ2(getNullableInt(rs, "q2"));
            response.setQ3(getNullableInt(rs, "q3"));
            response.setQ4(getNullableInt(rs, "q4"));
            response.setQ5(getNullableInt(rs, "q5"));
            response.setQ6(getNullableInt(rs, "q6"));
            response.setQ7(getNullableInt(rs, "q7"));
            response.setQ8(getNullableInt(rs, "q8"));
            response.setQ9(getNullableInt(rs, "q9"));
            response.setQ10(getNullableInt(rs, "q10"));
            response.setQ11(getNullableInt(rs, "q11"));
            response.setQ12(getNullableInt(rs, "q12"));
            response.setQ13(getNullableInt(rs, "q13"));
            response.setQ14(getNullableInt(rs, "q14"));
            response.setQ15(getNullableInt(rs, "q15"));
            response.setQ16(getNullableInt(rs, "q16"));
            response.setQ17(getNullableInt(rs, "q17"));
            response.setQ18(getNullableInt(rs, "q18"));
            response.setQ19(getNullableInt(rs, "q19"));
            response.setQ20(getNullableInt(rs, "q20"));
            return response;
        }, email);
    }

    // helper to map nullable integer columns
    private Integer getNullableInt(java.sql.ResultSet rs, String col) throws java.sql.SQLException {
        int v = rs.getInt(col);
        return rs.wasNull() ? null : v;
    }
}