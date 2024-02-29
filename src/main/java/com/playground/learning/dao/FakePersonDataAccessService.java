package com.playground.learning.dao;

import com.playground.learning.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person){
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    public List<Person> getAll(){
        return DB;
    }

    public int deletePersonById(UUID id){

        if (DB.removeIf(each -> each.getId().equals(id)))
            return 1;
        return 0;
    }

    public Optional<Person> selectPersonById(UUID id){
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }


}
