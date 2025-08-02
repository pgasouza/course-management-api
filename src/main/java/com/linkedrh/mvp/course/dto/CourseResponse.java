package com.linkedrh.mvp.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CourseResponse{
    private int id;
    private String name;
    private String description;
    private int duration;
    private Instant createdAt;
}
