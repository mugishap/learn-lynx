package com.java.main.springstarter.v1.models;

import com.java.main.springstarter.v1.enums.ECourseStatus;
import com.java.main.springstarter.v1.enums.ELessonStatus;
import com.java.main.springstarter.v1.fileHandling.File;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "lesson_title")
    private String lessonTitle;

    @Column(name = "lesson_description")
    private String lessonDescription;

    @OneToMany
    @JoinColumn(name = "lesson_multimedia")
    private List<File> lessonMultimedia;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    @Enumerated(EnumType.STRING)
    private ELessonStatus courseStatus=ELessonStatus.DRAFT;
}
