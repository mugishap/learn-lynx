package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IMarkRepository extends JpaRepository<Mark, UUID> {
}
