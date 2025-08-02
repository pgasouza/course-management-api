package com.linkedrh.mvp.course.controller;

import com.linkedrh.mvp.course.dto.CourseCreateRequest;
import com.linkedrh.mvp.course.dto.CourseResponse;
import com.linkedrh.mvp.course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
