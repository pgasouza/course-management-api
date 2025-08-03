package com.linkedrh.mvp.trainingSession.repository;

import com.linkedrh.mvp.trainingSession.dto.TrainingSessionCreateRequest;
import com.linkedrh.mvp.trainingSession.dto.TrainingSessionResponse;
import com.linkedrh.mvp.course.exception.CourseNotFoundException;

import com.linkedrh.mvp.trainingSession.dto.TrainingSessionUpdateRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class TrainingSessionDao {
    private final JdbcTemplate jdbc;

    public TrainingSessionDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public TrainingSessionResponse insert(TrainingSessionCreateRequest req) {
        return jdbc.queryForObject(
                "INSERT INTO training_sessions (start_date, end_date, location, course_id) " +
                        "VALUES (?, ?, ?, ?) RETURNING id, start_date, end_date, location, course_id",
                (rs, rowNum) -> mapRowToResponse(rs, rowNum),
                req.getStartDate(), req.getEndDate(), req.getLocation(), req.getCourseId()
        );
    }


    public Optional<TrainingSessionResponse> findById(int id) {
        String sql = """
        SELECT 
            ts.id,
            ts.start_date,
            ts.end_date,
            ts.location,
            ts.course_id,
            COUNT(tp.id) AS participants_count
        FROM training_sessions ts
        LEFT JOIN training_participants tp ON ts.id = tp.training_id
        WHERE ts.id = ?
        GROUP BY ts.id, ts.start_date, ts.end_date, ts.location, ts.course_id
    """;


        try {
            TrainingSessionResponse session = jdbc.queryForObject(
                    sql,
                    (rs, rowNum) -> mapRowToResponse(rs, rowNum),
                    id
            );
            return Optional.of(session);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }


    public List<TrainingSessionResponse> findAll() {
        String sql = """
        SELECT 
            ts.id,
            ts.start_date,
            ts.end_date,
            ts.location,
            ts.course_id,
            COUNT(tp.id) AS participants_count
        FROM training_sessions ts
        LEFT JOIN training_participants tp ON ts.id = tp.training_id
        GROUP BY ts.id, ts.start_date, ts.end_date, ts.location, ts.course_id
        ORDER BY ts.start_date, ts.end_date
    """;
        return jdbc.query(sql, this::mapRowToResponse);
    }


    public TrainingSessionResponse update(int id, TrainingSessionUpdateRequest req) {
        jdbc.update(
                "UPDATE training_sessions SET start_date = ?, end_date = ?, location = ? WHERE id = ?",
                req.getStartDate(), req.getEndDate(), req.getLocation(), id
        );
        return findById(id).orElseThrow(() -> new CourseNotFoundException("Training session not found: " + id));
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM training_sessions WHERE id = ?", id);
    }


    private TrainingSessionResponse mapRowToResponse(ResultSet rs, int row) throws SQLException {
        int participantsCount = 0;
        try {
            participantsCount = rs.getInt("participants_count");
        } catch (SQLException e) {
        }
        return new TrainingSessionResponse(
                rs.getInt("id"),
                rs.getDate("start_date").toLocalDate(),
                rs.getDate("end_date").toLocalDate(),
                rs.getString("location"),
                rs.getInt("course_id"),
                participantsCount
        );
    }

    public List<TrainingSessionResponse> findByCourseId(int courseId) {
        String sql = """
        SELECT 
            ts.id,
            ts.start_date,
            ts.end_date,
            ts.location,
            ts.course_id,
            COUNT(tp.id) AS participants_count
        FROM training_sessions ts
        LEFT JOIN training_participants tp ON ts.id = tp.training_id
        WHERE ts.course_id = ?
        GROUP BY ts.id, ts.start_date, ts.end_date, ts.location, ts.course_id
        ORDER BY ts.start_date, ts.end_date
    """;

        return jdbc.query(sql, this::mapRowToResponse, courseId);
    }
}
