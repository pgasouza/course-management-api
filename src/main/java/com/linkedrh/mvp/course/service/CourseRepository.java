package com.linkedrh.mvp.course.service;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;

public interface CourseRepository {
    CourseResponse create(CourseCreateRequest request);
    CourseResponse findById(int id);
}

