package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITagRepository  extends JpaRepository<Tag, UUID> {
}
