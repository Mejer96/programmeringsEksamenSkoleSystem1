package com.example.programmeringseksamenskolesystem.Service;

import com.example.programmeringseksamenskolesystem.IServices.IStudentService;
import com.example.programmeringseksamenskolesystem.Model.Student;
import com.example.programmeringseksamenskolesystem.Repository.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@Service
public class StudentService implements IStudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> findAll() {
        HashSet<Student> set = new HashSet<>();
        studentRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return studentRepository.findById(aLong);
    }
}

