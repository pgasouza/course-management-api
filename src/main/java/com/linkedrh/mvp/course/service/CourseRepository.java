package com.linkedrh.mvp.course.service;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;
import java.util.List;

public interface CourseRepository {
    CourseResponse create(CourseCreateRequest request);
    CourseResponse findById(int id);
    List<CourseResponse>findAll();
    CourseResponse update(int id, CourseCreateRequest request);
    void delete(int id);
}

