package com.example.programmeringseksamenskolesystem.Service;

import com.example.programmeringseksamenskolesystem.IServices.ITeacherService;
import com.example.programmeringseksamenskolesystem.Model.Teacher;
import com.example.programmeringseksamenskolesystem.Repository.TeacherRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@Service
public class TeacherService implements ITeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Set<Teacher> findAll() {
        Set<Teacher> teacherSet = new HashSet<>();
        teacherRepository.findAll().forEach(teacherSet::add);
        return teacherSet;
    }

    @Override
    public Teacher save(Teacher object) {
        return teacherRepository.save(object);
    }

    @Override
    public void delete(Teacher object) {
        teacherRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        teacherRepository.deleteById(aLong);
    }

    @Override
    public Optional<Teacher> findById(Long aLong) {
        return teacherRepository.findById(aLong);
    }

    @Override
    public Optional<Teacher> findByName(String name) {
        return teacherRepository.findByName(name);
    }
}
