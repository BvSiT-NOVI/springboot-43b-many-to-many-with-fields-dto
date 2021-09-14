package nl.gettoworktogether.studentcourse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String code;

    @Column
    String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
//    @JsonBackReference
//    @JsonManagedReference
    Set<StudentCourseResult> results;

    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentCourseResult> getResults() {
        return results;
    }

    public void setResults(Set<StudentCourseResult> results) {
        this.results = results;
    }
}