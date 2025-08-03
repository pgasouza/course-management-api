package com.linkedrh.mvp.trainingParticipant.controller;

import com.linkedrh.mvp.trainingParticipant.service.TrainingParticipantService;
import com.linkedrh.mvp.trainingParticipant.dto.TrainingParticipantAddRequest;
import com.linkedrh.mvp.trainingParticipant.dto.TrainingParticipantResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/training-sessions")
public class TrainingParticipantController {

    @Autowired
    private TrainingParticipantService participantService;

    @PostMapping("/{trainingId}/participants")
    public ResponseEntity<Void> addParticipant(
            @PathVariable Integer trainingId,
            @NotNull @Valid @RequestBody TrainingParticipantAddRequest request
    ) {
        participantService.addParticipant(trainingId, request.getEmployeeId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{trainingId}/participants")
    public ResponseEntity<List<TrainingParticipantResponse>> listParticipants(@PathVariable Integer trainingId) {
        List<TrainingParticipantResponse> participants = participantService.listParticipants(trainingId);
        return ResponseEntity.ok(participants);
    }

    @DeleteMapping("/{trainingId}/participants/{participantId}")
    public ResponseEntity<Void> deleteParticipant(
            @PathVariable Integer trainingId,
            @PathVariable Integer participantId) {
        participantService.deleteParticipant(trainingId, participantId);
        return ResponseEntity.noContent().build();
    }
}