package com.example.programmeringseksamenskolesystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int ectsPoints;
    private int maxStudents;
    @ManyToMany
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    private Teacher teacher;
    @Transient
    private long teacherID;

}
