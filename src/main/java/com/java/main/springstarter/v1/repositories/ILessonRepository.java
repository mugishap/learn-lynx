package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ILessonRepository extends JpaRepository<Lesson, UUID> {
}
