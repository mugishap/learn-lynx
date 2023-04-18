package live.learnlynx.api.v1.serviceImpls;

import live.learnlynx.api.v1.dtos.CreateEnrollmentDTO;
import live.learnlynx.api.v1.models.Course;
import live.learnlynx.api.v1.models.Enrollment;
import live.learnlynx.api.v1.repositories.ICourseRepository;
import live.learnlynx.api.v1.repositories.IEnrollmentRepository;
import live.learnlynx.api.v1.services.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements IEnrollmentService {

    private final IEnrollmentRepository enrollmentRepository;
    private final ICourseRepository courseRepository;

    @Override
    public Enrollment createEnrollment(CreateEnrollmentDTO dto) {
        return null;
    }

    @Override
    public Enrollment payEnrollment(UUID enrollmentId) {
        return null;
    }

    @Override
    public String deleteEnrollment() {
        return null;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return null;
    }

    @Override
    public List<Enrollment> getAllEnrollmentsForLoggedInUser() {
        return null;
    }

    @Override
    public List<Enrollment> getAllEnrollmentsByUserId(UUID userId) {
        return null;
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(UUID courseId) {
        Course course = this.courseRepository.getById(courseId);
        List<Enrollment> enrollments = this.enrollmentRepository.getEnrollmentsByCourse(course);
        return enrollments;
    }
}
