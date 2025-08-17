package com.linkedrh.mvp.trainingSession.service;

import com.linkedrh.mvp.trainingSession.dto.TrainingSessionCreateRequest;
import com.linkedrh.mvp.trainingSession.dto.TrainingSessionResponse;
import com.linkedrh.mvp.trainingSession.dto.TrainingSessionUpdateRequest;
import com.linkedrh.mvp.trainingSession.repository.TrainingSessionDao;
import com.linkedrh.mvp.course.exception.CourseNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingSessionService {

    private final TrainingSessionDao dao;

    public TrainingSessionService(TrainingSessionDao dao) {
        this.dao = dao;
    }

    public TrainingSessionResponse create(TrainingSessionCreateRequest req) {
        return dao.insert(req);
    }

    public List<TrainingSessionResponse> findByCourseId(int courseId) {
        return dao.findByCourseId(courseId);
    }

    public List<TrainingSessionResponse> findAll() {
        return dao.findAll();
    }

    public TrainingSessionResponse update(Integer id, @Valid TrainingSessionUpdateRequest req) {
        TrainingSessionResponse existing = findById(id);




        return dao.update(id, req);
    }


    public TrainingSessionResponse findById(Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Training session not found: " + id));
    }


    public void delete(Integer id) {

        findById(id);
        dao.delete(id);
    }


}