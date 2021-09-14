package nl.gettoworktogether.studentcourse.service;

import nl.gettoworktogether.studentcourse.exceptions.RecordNotFoundException;
import nl.gettoworktogether.studentcourse.model.Course;
import nl.gettoworktogether.studentcourse.model.Student;
import nl.gettoworktogether.studentcourse.model.StudentCourseResult;
import nl.gettoworktogether.studentcourse.model.StudentCourseResultKey;
import nl.gettoworktogether.studentcourse.payload.ResultDto;
import nl.gettoworktogether.studentcourse.payload.StudentCourseResultDto;
import nl.gettoworktogether.studentcourse.payload.StudentDto;
import nl.gettoworktogether.studentcourse.repository.CourseRepository;
import nl.gettoworktogether.studentcourse.repository.StudentCourseResultRepository;
import nl.gettoworktogether.studentcourse.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentCourseResultServiceImpl implements StudentCourseResultService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentCourseResultRepository studentCourseResultRepository;

    @Override
    public Collection<StudentCourseResult> getAllResults() {
        Collection<StudentCourseResult> results = studentCourseResultRepository.findAll();
        return results;
    }

    @Override
    public Collection<StudentCourseResultDto> getAllResults2() {
        Collection<StudentCourseResultDto> studentCourses = new ArrayList<>();
        for (Student student: studentRepository.findAll()){
            StudentCourseResultDto studentCourseResultDto = new StudentCourseResultDto();
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentCourseResultDto.setStudent(studentDto);

            Collection<StudentCourseResult> studentResults = studentCourseResultRepository.findAllByStudentId(student.getId());
            long totalScore=0;
            for (StudentCourseResult studentCourseResult:studentResults){
                ResultDto resultDto = new ResultDto();
                resultDto.setCourse(studentCourseResult.getCourse());
                resultDto.setDate(studentCourseResult.getDate());
                resultDto.setScore(studentCourseResult.getScore());
                totalScore+=studentCourseResult.getScore();
                studentCourseResultDto.getResults().add(resultDto);
            }
            if (studentResults.size()>0){
                studentCourseResultDto.setAverageScore(totalScore/ (double) studentResults.size());
            }
            studentCourses.add(studentCourseResultDto);
        }
        return studentCourses;
    }

    @Override
    public Collection<StudentCourseResult> getResultsByStudentId(long studentId) {
        return studentCourseResultRepository.findAllByStudentId(studentId);
    }

    @Override
    public Collection<StudentCourseResult> getResultsByCourseId(long courseId) {
        return studentCourseResultRepository.findAllByCourseId(courseId);
    }

    @Override
    public StudentCourseResult getResultById(long studentId, long courseId) {
        return studentCourseResultRepository.findById(new StudentCourseResultKey(studentId, courseId)).orElse(null);
    }

    @Override
    public StudentCourseResultKey addResult(long studentId, long courseId, StudentCourseResult result) {
        if (!studentRepository.existsById(studentId)) { throw new RecordNotFoundException(); }
        Student student = studentRepository.findById(studentId).orElse(null);
        if (!courseRepository.existsById(courseId)) { throw new RecordNotFoundException(); }
        Course course = courseRepository.findById(courseId).orElse(null);
        result.setStudent(student);
        result.setCourse(course);
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        result.setId(id);
        studentCourseResultRepository.save(result);
        return id;
    }

    @Override
    public void updateResult(long studentId, long courseId, StudentCourseResult result) {
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        if (!studentCourseResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        StudentCourseResult existingResult = studentCourseResultRepository.findById(id).orElse(null);
        existingResult.setDate(result.getDate());
        existingResult.setScore(result.getScore());
        studentCourseResultRepository.save(existingResult);
    }

    @Override
    public void partialUpdateResult(long studentId, long courseId, StudentCourseResult result) {
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        if (!studentCourseResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        StudentCourseResult existingResult = studentCourseResultRepository.findById(id).orElse(null);
        if (result.getDate() != null) {
            existingResult.setDate(result.getDate());
        }
        if (result.getScore() != null) {
            existingResult.setScore(result.getScore());
        }
        studentCourseResultRepository.save(existingResult);
    }

    @Override
    public void deleteResult(long studentId, long courseId) {
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        if (!studentCourseResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        studentCourseResultRepository.deleteById(id);
    }

}
