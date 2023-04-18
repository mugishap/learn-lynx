package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Course;
import com.java.main.springstarter.v1.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IEnrollmentRepository  extends JpaRepository<Enrollment, UUID> {

    @Query("SELECT e FROM Enrollment  e WHERE e.course=:course")
    public List<Enrollment> getEnrollmentsByCourse(Course course);

}
