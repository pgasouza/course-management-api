package com.linkedrh.mvp.course.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CourseCreateRequest {

    @NotBlank @Size(max = 100)
    private String name;


    @Size(max = 4000)
    private String description;


    @Min(1)
    private int duration;

}
