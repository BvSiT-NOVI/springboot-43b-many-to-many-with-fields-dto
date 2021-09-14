package nl.gettoworktogether.studentcourse.repository;

import nl.gettoworktogether.studentcourse.model.StudentCourseResult;
import nl.gettoworktogether.studentcourse.model.StudentCourseResultKey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentCourseResultRepository extends JpaRepository<StudentCourseResult, StudentCourseResultKey> {
    Collection<StudentCourseResult> findAllByStudentId(long studentId);
    Collection<StudentCourseResult> findAllByCourseId(long courseId);
}
