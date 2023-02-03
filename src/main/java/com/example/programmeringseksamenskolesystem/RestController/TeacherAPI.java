package com.example.programmeringseksamenskolesystem.RestController;

import com.example.programmeringseksamenskolesystem.Model.Teacher;
import com.example.programmeringseksamenskolesystem.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@RestController
@CrossOrigin
public class TeacherAPI {
    private TeacherService teacherService;

    @PostMapping("/api/teacher/create-teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        System.out.println("/api/teacher/create-teacher endpoint reached");
        Teacher teacherObject = teacherService.save(teacher);

        return new ResponseEntity<>(teacherObject, HttpStatus.OK);
    }

    @GetMapping("/api/teacher/find-all-teachers")
    public ResponseEntity<Set<Teacher>> findAllTeachers() {
        System.out.println("/api/teacher/find-all-teachers endpoint reached");
        Set<Teacher> teachers = teacherService.findAll();

        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("api/teacher/find-teacher-by-name")
    public ResponseEntity<Teacher> findTeacherByName(@RequestBody Teacher object) {
        System.out.println("api/teacher/find-by-name endpoint reached");
        Optional<Teacher> containerObject = teacherService.findByName(object.getName());
        Teacher teacherObject = containerObject.orElse(new Teacher());

        return new ResponseEntity<>(teacherObject, HttpStatus.OK);
    }

    @PostMapping("api/teacher/delete-by-name")
    public ResponseEntity<Teacher> deleteTeacherByID(@RequestBody Teacher teacher) {
        System.out.println("api/teacher/find-by-name endpoint reached");
        teacherService.delete(teacher);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
