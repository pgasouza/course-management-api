package com.linkedrh.mvp.trainingSession.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrainingSessionResponse {
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private Integer courseId;
    private Integer participantsCount;

    public TrainingSessionResponse(Integer id, LocalDate startDate, LocalDate endDate,
                                   String location, Integer courseId, Integer participantsCount) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.courseId = courseId;
        this.participantsCount = participantsCount;
    }
}



