package com.playground.learning.service;

import com.playground.learning.dao.PersonDao;
import com.playground.learning.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PersonService {

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDAO) {
        this.personDAO = personDAO;
    }

    private final PersonDao personDAO;

    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }


    public List<Person> getAll(){
        return personDAO.getAll();
    }

    public int removePerson(UUID id){
        return personDAO.deletePersonById(id);
    }

    public Optional<Person> selectById(UUID id){
        return personDAO.selectPersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return this.personDAO.updatePersonById(id, newPerson);
    }


}
