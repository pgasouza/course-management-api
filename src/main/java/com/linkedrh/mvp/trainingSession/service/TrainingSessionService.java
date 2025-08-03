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
        // Você pode colocar regras de negócio aqui antes de criar

        return dao.insert(req);
    }

    public List<TrainingSessionResponse> findByCourseId(int courseId) {
        return dao.findByCourseId(courseId);
    }

    public List<TrainingSessionResponse> findAll() {
        return dao.findAll();
    }

    public TrainingSessionResponse update(Integer id, @Valid TrainingSessionUpdateRequest req) {
        // Busca a turma existente para garantir que ela existe
        TrainingSessionResponse existing = findById(id);

        // Não verifica courseId no req, pois não existe e não deve ser alterado

        // Apenas atualiza os campos permitidos no DAO
        return dao.update(id, req);
    }


    public TrainingSessionResponse findById(Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Training session not found: " + id));
    }


    public void delete(Integer id) {
        // Você pode verificar se existe antes, lançar exceção etc
        findById(id);
        dao.delete(id);
    }


}