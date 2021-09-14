package nl.gettoworktogether.studentcourse.service;

import nl.gettoworktogether.studentcourse.model.StudentCourseResult;
import nl.gettoworktogether.studentcourse.model.StudentCourseResultKey;
import nl.gettoworktogether.studentcourse.payload.ResultDto;
import nl.gettoworktogether.studentcourse.payload.StudentCourseResultDto;

import java.util.Collection;

public interface StudentCourseResultService {

    Collection<StudentCourseResult> getAllResults();

    Collection<StudentCourseResultDto> getAllResults2();

    Collection<StudentCourseResult> getResultsByStudentId(long studentId);
    Collection<StudentCourseResult> getResultsByCourseId(long studentId);
    StudentCourseResult getResultById(long studentId, long courseId);

    StudentCourseResultKey addResult(long studentId, long courseId, StudentCourseResult result);
    void updateResult(long studentId, long courseId, StudentCourseResult result);
    void partialUpdateResult(long studentId, long courseId, StudentCourseResult result);
    void deleteResult(long studentId, long courseId);

}
