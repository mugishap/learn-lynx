package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.dtos.CreateLessonDTO;
import com.java.main.springstarter.v1.dtos.UpdateLessonDTO;
import com.java.main.springstarter.v1.fileHandling.File;
import com.java.main.springstarter.v1.models.Lesson;
import com.java.main.springstarter.v1.services.ILessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements ILessonService {
    @Override
    public Lesson createLesson(CreateLessonDTO dto, List<File> lessonMultimedia) {
        return null;
    }

    @Override
    public Lesson updateLesson(UpdateLessonDTO dto, List<File> lessonMultimedia) {
        return null;
    }

    @Override
    public String deleteLesson(UUID lessonId) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsByCourse(UUID courseId) {
        return null;
    }

    @Override
    public Lesson getLessonById(UUID lessonId) {
        return null;
    }
}
