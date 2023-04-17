package com.java.main.springstarter.v1.models;

import com.java.main.springstarter.v1.enums.ECurrency;
import com.java.main.springstarter.v1.enums.EcourseStatus;
import com.java.main.springstarter.v1.fileHandling.File;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_description")
    private String courseDescription;

    @OneToOne
    @JoinColumn(name="course_introductory_video")
    private File courseIntroductoryVideo;

    @Column(name = "course_duration")
    private int courseDuration;

    @Column(name = "course_start_date")
    private LocalDate courseStartDate;

    @Column(name = "course_end_date")
    private LocalDate courseEndDate;

    @ManyToOne
    @JoinColumn(name="course_instructor")
    private User courseInstructor;

    @ManyToMany
    @JoinColumn(name = "course_tags")
    private List<Tag> courseTags;

    @OneToOne
    @JoinColumn(name="course_image")
    private File courseImage;

    @Enumerated(EnumType.STRING)
    private EcourseStatus courseStatus=EcourseStatus.DRAFT;

    @Column(name = "course_enrollment_fee")
    private int courseEnrollmentFee;

    @Column(name = "course_enrollment_fee_currency")
    private ECurrency currency=ECurrency.RWF;


}
