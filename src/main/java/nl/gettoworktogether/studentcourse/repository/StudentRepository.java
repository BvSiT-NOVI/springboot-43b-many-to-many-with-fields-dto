package nl.gettoworktogether.studentcourse.repository;

import nl.gettoworktogether.studentcourse.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByName(String name);
}
