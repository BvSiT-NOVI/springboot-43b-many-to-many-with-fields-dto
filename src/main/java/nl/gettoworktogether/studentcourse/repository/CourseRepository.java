package nl.gettoworktogether.studentcourse.repository;

import nl.gettoworktogether.studentcourse.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Collection<Course> findAllByName(String name);
}
