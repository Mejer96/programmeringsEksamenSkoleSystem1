package com.example.programmeringseksamenskolesystem.Repository;

import com.example.programmeringseksamenskolesystem.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Set<Course> findCoursesById(long id);

}
