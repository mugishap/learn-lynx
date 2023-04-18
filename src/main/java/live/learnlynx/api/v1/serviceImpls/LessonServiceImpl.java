package live.learnlynx.api.v1.serviceImpls;

import live.learnlynx.api.v1.dtos.CreateLessonDTO;
import live.learnlynx.api.v1.dtos.UpdateLessonDTO;
import live.learnlynx.api.v1.fileHandling.File;
import live.learnlynx.api.v1.models.Lesson;
import live.learnlynx.api.v1.services.ILessonService;
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
