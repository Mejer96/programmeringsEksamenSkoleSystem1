package com.example.programmeringseksamenskolesystem.IServices;

import com.example.programmeringseksamenskolesystem.Model.Teacher;

import java.util.Optional;

public interface ITeacherService extends ICRUDService<Teacher, Long> {

    Optional<Teacher> findByName(String name);
}
