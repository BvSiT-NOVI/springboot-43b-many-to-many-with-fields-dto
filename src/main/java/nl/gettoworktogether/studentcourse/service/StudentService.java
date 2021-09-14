package nl.gettoworktogether.studentcourse.service;

import nl.gettoworktogether.studentcourse.model.Student;
import nl.gettoworktogether.studentcourse.payload.StudentDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;


public interface StudentService {

    Collection<Student> getAllStudents();
    Student getStudentById(long id);
    Collection<Student> getStudents(String name);
    long createStudent(Student student);

    Student createStudent(@Valid StudentDto student);

    void updateStudent(long id, Student student);
    void partialUpdateStudent(long id, Map<String, String> fields);
    void deleteStudent(long id);

}
