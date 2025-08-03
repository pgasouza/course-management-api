package com.linkedrh.mvp.trainingParticipant.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainingParticipantAddRequest {

    @NotNull
    private Integer employeeId;
}