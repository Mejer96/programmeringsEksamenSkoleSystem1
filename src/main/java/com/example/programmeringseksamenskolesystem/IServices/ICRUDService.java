package com.example.programmeringseksamenskolesystem.IServices;

import java.util.Optional;
import java.util.Set;

public interface ICRUDService<T, ID> {
    Set<T> findAll();
    T save(T object);
    void delete(T object);
    void deleteByID(ID id);
    Optional<T> findById(ID id);
}
