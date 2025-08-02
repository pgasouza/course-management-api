package com.linkedrh.mvp.course.repository;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao {
    private final JdbcTemplate jdbc;

    public CourseDao(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public CourseResponse insert(CourseCreateRequest req){
        return jdbc.queryForObject(
                "INSERT INTO courses (name, description, duration) VALUES (?, ?, ?) RETURNING id, name, description, duration, created_at",
                (rs, row) -> new CourseResponse(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getTimestamp("created_at").toInstant()
                ),
                req.getName(), req.getDescription(), req.getDuration()
        );
    }

    public Optional<CourseResponse> findById(int id){
        try {
            CourseResponse course = jdbc.queryForObject(
                    "SELECT * FROM courses WHERE id = ?",
                    this::mapRowToResponse,
                    id
            );
            return Optional.ofNullable(course);
        } catch (EmptyResultDataAccessException error) {
            return Optional.empty();
        }
    }

    private CourseResponse mapRowToResponse(ResultSet rs, int row) throws SQLException {
        return new CourseResponse(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("duration"),
                rs.getTimestamp("created_at").toInstant()
        );
    }
}

