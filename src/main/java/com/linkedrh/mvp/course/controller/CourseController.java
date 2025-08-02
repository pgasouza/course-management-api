package com.linkedrh.mvp.course.controller;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;
import com.linkedrh.mvp.course.service.CourseService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController{
    private final CourseService service;

    public CourseController(CourseService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CourseResponse>create(@Valid @RequestBody CourseCreateRequest req){
        CourseResponse course = service.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> findById (@PathVariable("id") int id){
        CourseResponse course = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>>findAll(){
        List<CourseResponse> courses = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse>update(
            @PathVariable("id")int id,
            @Valid @RequestBody CourseCreateRequest req){
        CourseResponse updated = service.update(id, req);
            return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable("id")int id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

