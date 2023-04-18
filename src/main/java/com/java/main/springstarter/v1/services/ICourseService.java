package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreateCourseDTO;
import com.java.main.springstarter.v1.dtos.UpdateCourseDTO;
import com.java.main.springstarter.v1.fileHandling.File;
import com.java.main.springstarter.v1.models.Course;
import com.java.main.springstarter.v1.models.User;

import java.util.List;
import java.util.UUID;

public interface ICourseService {

    public Course createCourse(CreateCourseDTO dto, File courseImage, File courseIntroductoryVideo);
    public Course updateCourse(UUID courseId,UpdateCourseDTO dto,File courseImage, File courseIntroductoryVideo);

    public String deleteCourse(UUID courseId);
    public List<Course> getCourses();
    public Course getCourseById(UUID id);

    public Course getCourseByInstructor(UUID instructorId);
    public List<User> getLearnersPursuingCourse(UUID courseId);
}
