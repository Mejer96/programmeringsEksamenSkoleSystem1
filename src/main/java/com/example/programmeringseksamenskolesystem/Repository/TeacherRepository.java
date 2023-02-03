package com.example.programmeringseksamenskolesystem.Repository;


import com.example.programmeringseksamenskolesystem.Model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Optional<Teacher> findByName(String name);

}
