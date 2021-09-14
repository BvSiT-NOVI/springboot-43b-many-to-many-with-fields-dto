package nl.gettoworktogether.studentcourse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @OneToMany(mappedBy = "student")
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