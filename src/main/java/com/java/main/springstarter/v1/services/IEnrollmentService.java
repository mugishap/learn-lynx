package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreateEnrollmentDTO;
import com.java.main.springstarter.v1.models.Enrollment;

import java.util.List;
import java.util.UUID;

public interface IEnrollmentService {

    public Enrollment createEnrollment(CreateEnrollmentDTO dto);
    public Enrollment payEnrollment(UUID enrollmentId);
    public String deleteEnrollment();
    public List<Enrollment> getAllEnrollments();
    public List<Enrollment> getAllEnrollmentsForLoggedInUser();
    public List<Enrollment> getAllEnrollmentsByUserId(UUID userId);
    public List<Enrollment> getEnrollmentsByCourseId(UUID courseId);

}
