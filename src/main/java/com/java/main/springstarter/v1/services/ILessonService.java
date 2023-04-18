package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreateLessonDTO;
import com.java.main.springstarter.v1.dtos.UpdateLessonDTO;
import com.java.main.springstarter.v1.fileHandling.File;
import com.java.main.springstarter.v1.models.Lesson;

import java.util.List;
import java.util.UUID;

public interface ILessonService {

    public Lesson createLesson(CreateLessonDTO dto, List<File> lessonMultimedia);
    public Lesson updateLesson(UpdateLessonDTO dto,List<File> lessonMultimedia);
    public String deleteLesson(UUID lessonId);
    public List<Lesson> getLessonsByCourse(UUID courseId);
    public Lesson getLessonById(UUID lessonId);

}
