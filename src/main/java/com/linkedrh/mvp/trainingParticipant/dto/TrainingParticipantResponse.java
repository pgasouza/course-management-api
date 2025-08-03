package com.linkedrh.mvp.trainingParticipant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TrainingParticipantResponse {
    private Integer employeeId;
    private String name;
    private String cpf;
    private String position;
}