package com.linkedrh.mvp.trainingParticipant.repository;

import com.linkedrh.mvp.trainingParticipant.dto.TrainingParticipantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrainingParticipantDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Integer trainingId, Integer employeeId) {
        String sql = "INSERT INTO training_participants (training_id, employee_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, trainingId, employeeId);
    }

    public List<TrainingParticipantResponse> findParticipantsByTrainingId(Integer trainingId) {
        String sql = """
            SELECT e.id as employee_id, e.name, e.cpf, e.position
            FROM employees e
            INNER JOIN training_participants tp ON e.id = tp.employee_id
            WHERE tp.training_id = ?
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToResponse(rs), trainingId);
    }

    private TrainingParticipantResponse mapRowToResponse(ResultSet rs) throws SQLException {
        return new TrainingParticipantResponse(
                rs.getInt("employee_id"),
                rs.getString("name"),
                rs.getString("cpf"),
                rs.getString("position")
        );
    }

    public void delete(Integer trainingId, Integer participantId) {
        String sql = "DELETE FROM training_participants WHERE training_id = ? AND employee_id = ?";
        jdbcTemplate.update(sql, trainingId, participantId);
    }
}