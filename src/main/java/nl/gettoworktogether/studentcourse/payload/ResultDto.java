package nl.gettoworktogether.studentcourse.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import nl.gettoworktogether.studentcourse.model.Course;
import nl.gettoworktogether.studentcourse.model.StudentCourseResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResultDto {
    private Course course;
    @JsonProperty("date_exam")
    private LocalDate date;
    private double score;
}
