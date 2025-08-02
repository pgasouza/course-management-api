package com.linkedrh.mvp.course.service;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;
import com.linkedrh.mvp.course.exception.CourseNotFoundException;
import com.linkedrh.mvp.course.repository.CourseDao;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements CourseRepository{
    private final CourseDao dao;

    public CourseService(CourseDao dao){
        this.dao = dao;
    }

    @Override
    public CourseResponse create(CourseCreateRequest request){
        return dao.insert(request);
    }

    @Override
    public CourseResponse findById(int id){
        return dao.findById(id).orElseThrow(() -> new CourseNotFoundException(Integer.toString(id)));
    }
}
