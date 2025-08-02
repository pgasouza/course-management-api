package com.linkedrh.mvp.course.service;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;
import com.linkedrh.mvp.course.exception.CourseNotFoundException;
import com.linkedrh.mvp.course.repository.CourseDao;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<CourseResponse>findAll(){
        return dao.findAll();
    }

    @Override
    public CourseResponse update(int id, CourseCreateRequest request){
        findById(id);
        return dao.update(id, request);
    }

    @Override
    public void delete(int id){
        findById(id);
        dao.delete(id);
    }
}
