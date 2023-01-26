package com.vungdo.peopledbweb.web.controller;

import com.vungdo.peopledbweb.biz.model.Person;
import com.vungdo.peopledbweb.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }
    @ModelAttribute("person")
    public Person getPerson() {

        Person person = new Person();
        return person;
    }
    @GetMapping
    public String showPeoplePage() {
        return "people";
    }

    @PostMapping
    public String savePerson(Person person){
        System.out.println(person);
        personRepository.save(person);
        return "redirect:people";
    }
}
