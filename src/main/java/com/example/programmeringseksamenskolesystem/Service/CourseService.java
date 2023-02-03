package com.example.programmeringseksamenskolesystem.Service;

import com.example.programmeringseksamenskolesystem.IServices.ICourseService;
import com.example.programmeringseksamenskolesystem.Model.Course;
import com.example.programmeringseksamenskolesystem.Repository.CourseRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Setter
@Getter
@Service
public class CourseService implements ICourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> findAll() {
        HashSet<Course> coursesSet = new HashSet<>();
        courseRepository.findAll().forEach(coursesSet::add);
        return coursesSet;
    }

    @Override
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Override
    public void delete(Course object) {
        courseRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        courseRepository.deleteById(aLong);
    }

    @Override
    public Optional<Course> findById(Long aLong) {
        return courseRepository.findById(aLong);
    }
}
