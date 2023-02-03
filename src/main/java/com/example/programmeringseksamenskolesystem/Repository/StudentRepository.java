package com.example.programmeringseksamenskolesystem.Repository;

import com.example.programmeringseksamenskolesystem.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
