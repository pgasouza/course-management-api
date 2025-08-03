package com.linkedrh.mvp.trainingSession.controller;

import com.linkedrh.mvp.trainingSession.dto.TrainingSessionCreateRequest;
import com.linkedrh.mvp.trainingSession.dto.TrainingSessionResponse;
import com.linkedrh.mvp.trainingSession.dto.TrainingSessionUpdateRequest;
import com.linkedrh.mvp.trainingSession.service.TrainingSessionService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-sessions")
public class TrainingSessionController {

    private final TrainingSessionService service;

    public TrainingSessionController(TrainingSessionService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<TrainingSessionResponse> create(@Valid @RequestBody TrainingSessionCreateRequest request) {
        TrainingSessionResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TrainingSessionResponse>> findByCourseId(@PathVariable int courseId) {
        return ResponseEntity.ok(service.findByCourseId(courseId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingSessionResponse> findById(@PathVariable Integer id) {
        TrainingSessionResponse session = service.findById(id);
        return ResponseEntity.ok(session);
    }


    @GetMapping
    public ResponseEntity<List<TrainingSessionResponse>> findAll() {
        List<TrainingSessionResponse> list = service.findAll();
        return ResponseEntity.ok(list);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TrainingSessionResponse> update(@PathVariable Integer id,
                                                          @Valid @RequestBody TrainingSessionUpdateRequest request) {
        TrainingSessionResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}