package nl.gettoworktogether.studentcourse.controller;

import nl.gettoworktogether.studentcourse.model.Student;
import nl.gettoworktogether.studentcourse.model.StudentCourseResult;
import nl.gettoworktogether.studentcourse.model.StudentCourseResultKey;
import nl.gettoworktogether.studentcourse.payload.StudentDto;
import nl.gettoworktogether.studentcourse.service.StudentCourseResultService;
import nl.gettoworktogether.studentcourse.service.StudentService;
import nl.gettoworktogether.studentcourse.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * StudentController
 * Implements endpoints for student resource
 *
 * GET /students
 * POST /students
 * GET /students/{id}
 * PUT /students/{id}
 * PATCH /students/{id}
 * DELETE /students/{id}
 *
 * GET /students/{id}/courses => return courses with id
 * POST /students/{id}/courses => body { course_id:{id} }
 * DELETE /students/{id}/courses/{course_id}
 *
 */

@RestController
@RequestMapping(value = "/dto/students")
public class StudentDtoController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentCourseResultService studentCourseResultService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchStudents(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(studentService.getStudents(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.createStudent(studentDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(student.getId()).toUri();
        //Location of the created student is returned in the header
        return ResponseEntity.created(location).body(student);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateStudentPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        studentService.partialUpdateStudent(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/courses")
    public ResponseEntity<Object> getStudentCourseResults(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(studentCourseResultService.getResultsByStudentId(id));
    }

    @GetMapping(value = "/{student_id}/courses/{course_id}")
    public ResponseEntity<Object> getStudentCourseResult(@PathVariable("student_id") long studentId,
                                                         @PathVariable("course_id") long courseId) {
        return ResponseEntity.ok().body(studentCourseResultService.getResultById(studentId, courseId));
    }

    @PostMapping(value = "/{student_id}/courses/{course_id}")
    public ResponseEntity<Object> addStudentCourseResult(@PathVariable("student_id") long studentId,
                                                         @PathVariable("course_id") long courseId,
                                                         @RequestBody StudentCourseResult result) {
        StudentCourseResultKey newId = studentCourseResultService.addResult(studentId, courseId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

}