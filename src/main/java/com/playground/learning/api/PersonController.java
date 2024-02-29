package com.playground.learning.api;

import com.playground.learning.model.Person;
import com.playground.learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        this.personService.addPerson(person);

    }

    @GetMapping
    public List<Person> getSth(){
        return this.personService.getAll();
    }

    @DeleteMapping
    public int removeById(@RequestBody Person person){
        return this.personService.removePerson(person.getId());
    }

    @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id")UUID id){
        return this.personService.selectById(id).orElse(null);
    }

}
