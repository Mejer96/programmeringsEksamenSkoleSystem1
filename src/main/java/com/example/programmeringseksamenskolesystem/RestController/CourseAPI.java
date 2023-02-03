package com.example.programmeringseksamenskolesystem.RestController;

import com.example.programmeringseksamenskolesystem.Model.Course;
import com.example.programmeringseksamenskolesystem.Model.CoursesAndStudents;
import com.example.programmeringseksamenskolesystem.Model.Student;
import com.example.programmeringseksamenskolesystem.Model.Teacher;
import com.example.programmeringseksamenskolesystem.Service.CourseService;
import com.example.programmeringseksamenskolesystem.Service.StudentService;
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
public class CourseAPI {
    private CourseService courseService;
    private TeacherService teacherService;
    private StudentService studentService;

    @PostMapping("/api/course/create-course")
    public ResponseEntity<Course> createCourse(@RequestBody Course object) {
        System.out.println("/api/course/create-course endpoint reached");
        Optional<Teacher> containerObject = teacherService.findById(object.getTeacherID());
        Teacher teacherObject = containerObject.orElse(new Teacher());
        object.setTeacher(teacherObject);
        Course courseObject = courseService.save(object);

        return new ResponseEntity<>(courseObject, HttpStatus.OK);
    }

    @GetMapping("/api/course/find-all-courses")
    public ResponseEntity<Set<Course>> findAllCourses() {
        System.out.println("/api/course/find-all-courses endpoint reached");
        Set<Course> courses = courseService.findAll();

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/api/course/add-student-to-course")
    public void addStudentsToCourse(@RequestBody CoursesAndStudents object) {
        System.out.println("/api/course/add-student-to-course endpoint reached ");
        Optional<Student> containerObject = studentService.findById(object.getStudentID());
        Student studentObject = containerObject.orElse(new Student());

        Optional<Course> containerObjectCourse = courseService.findById(object.getCourseID());
        Course courseObject = containerObjectCourse.orElse(new Course());

        courseObject.getStudents().add(studentObject);
        courseService.save(courseObject);
    }

}
