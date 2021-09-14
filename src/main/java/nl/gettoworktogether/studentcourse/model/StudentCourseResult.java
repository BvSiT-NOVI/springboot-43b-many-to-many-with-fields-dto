package nl.gettoworktogether.studentcourse.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_course_results")
public class StudentCourseResult {

    @EmbeddedId
    private StudentCourseResultKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    private LocalDate date;

    @Column
    private Double score;

    // getters and setters
    public StudentCourseResultKey getId() {
        return id;
    }
    public void setId(StudentCourseResultKey id) {
        this.id = id;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }

}