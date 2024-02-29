package com.playground.learning.dao;

import com.playground.learning.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return this.insertPerson(id, person);
    }
    List<Person> getAll();
    int deletePersonById(UUID id);
//    int updatePersonById(UUID id, Person person);
    Optional<Person> selectPersonById(UUID id);
}
