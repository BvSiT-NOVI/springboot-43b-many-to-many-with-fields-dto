package nl.gettoworktogether.studentcourse.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import nl.gettoworktogether.studentcourse.model.StudentCourseResult;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentCourseResultDto {
    StudentDto student;
    List<ResultDto> results= new ArrayList<>();
    @JsonProperty("average_score")
    double averageScore;
}
