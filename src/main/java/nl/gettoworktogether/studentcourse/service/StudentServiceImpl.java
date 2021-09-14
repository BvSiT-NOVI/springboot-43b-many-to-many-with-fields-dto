package nl.gettoworktogether.studentcourse.service;

import nl.gettoworktogether.studentcourse.exceptions.UserNotFoundException;
import nl.gettoworktogether.studentcourse.model.Student;
import nl.gettoworktogether.studentcourse.repository.CourseRepository;
import nl.gettoworktogether.studentcourse.repository.StudentCourseResultRepository;
import nl.gettoworktogether.studentcourse.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentCourseResultRepository studentCourseResultRepository;

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudents(String name) {
        if (name.isEmpty()) {
            return studentRepository.findAll();
        }
        else {
            return studentRepository.findAllByName(name);
        }
    }

    @Override
    public Student getStudentById(long id) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public long createStudent(Student student) {
        Student storedStudent = studentRepository.save(student);
        return storedStudent.getId();
    }

    @Override
    public void updateStudent(long id, Student student) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        Student storedStudent = studentRepository.findById(id).orElse(null);
        storedStudent.setName(student.getName());
        studentRepository.save(student);
    }

    @Override
    public void partialUpdateStudent(long id, Map<String, String> fields) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        Student storedStudent = studentRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "name":
                    storedStudent.setName((String) fields.get(field));
                    break;
            }
        }
        studentRepository.save(storedStudent);
    }

    @Override
    public void deleteStudent(long id) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        studentRepository.deleteById(id);
    }

}
