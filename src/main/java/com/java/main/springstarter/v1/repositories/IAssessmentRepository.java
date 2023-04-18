package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.fileHandling.File;
import com.java.main.springstarter.v1.models.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAssessmentRepository  extends JpaRepository<Assessment, UUID> {
}
