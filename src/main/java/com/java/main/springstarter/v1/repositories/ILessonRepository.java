package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, UUID> {
}
