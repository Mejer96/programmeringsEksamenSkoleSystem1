package com.example.programmeringseksamenskolesystem.RestController;

import com.example.programmeringseksamenskolesystem.Model.Student;
import com.example.programmeringseksamenskolesystem.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin
public class StudentAPI {
    private StudentService studentService;

    @PostMapping("/api/student/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student object) {
        System.out.println("/api/student/create-student endpoint reached");
        Student studentObject = studentService.save(object);

        return new ResponseEntity<>(studentObject, HttpStatus.OK);
    }

}
