package live.learnlynx.api.v1.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class CreateLessonDTO {

    private String lessonTitle;
    private String lessonDescription;
    private UUID courseId;

}
