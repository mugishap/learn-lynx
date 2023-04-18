package com.java.main.springstarter.v1.dtos;

import com.java.main.springstarter.v1.enums.ECurrency;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
public class UpdateCourseDTO {

    private String courseTitle;
    private int courseDuration;
    private int courseStartDate;
    private UUID courseInstructor;
    private List<UUID> tags;
    private int courseEnrollmentFee;
    private ECurrency courseEnrollmentFeeCurrency;


}
