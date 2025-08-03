package com.linkedrh.mvp.trainingParticipant.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.linkedrh.mvp.trainingParticipant.dto.TrainingParticipantResponse;
import com.linkedrh.mvp.trainingParticipant.repository.TrainingParticipantDao;

import java.util.List;

@Service
public class TrainingParticipantService {

    @Autowired
    private TrainingParticipantDao participantDao;

    public void addParticipant(Integer trainingId, Integer employeeId) {
        participantDao.insert(trainingId, employeeId);
    }

    public List<TrainingParticipantResponse> listParticipants(Integer trainingId) {
        return participantDao.findParticipantsByTrainingId(trainingId);
    }


    public void deleteParticipant(Integer trainingId, Integer participantId) {
        participantDao.delete(trainingId, participantId);
    }
}