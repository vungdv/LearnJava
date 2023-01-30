package com.vungdo.peopledbweb.web.controller;

import com.vungdo.peopledbweb.biz.model.Person;
import com.vungdo.peopledbweb.biz.service.PersonService;
import com.vungdo.peopledbweb.data.LocalFileRepository;
import com.vungdo.peopledbweb.data.PersonRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
@Log4j2
public class PeopleController {

    private final PersonService personService;

    public PeopleController(PersonService personService) {
        this.personService = personService;
    }
    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return personService.findAll();
    }
    @ModelAttribute("person")
    public Person getPerson() {

        return new Person();
    }
    @GetMapping
    public String showPeoplePage() {
        return "people";
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<Resource> getResource(@PathVariable String fileName) {
        return ResponseEntity
                .ok()
                .body(personService.getResource(fileName));
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors, @RequestParam(name = "photoFileName") MultipartFile photoFile) throws IOException {
        log.info(person);
        log.info(photoFile.getSize());
        log.info("Errors: " + errors);

        if(!errors.hasErrors()) {
            personService.save(person, photoFile.getInputStream());
            return "redirect:people";
        }
        return "people";
    }
    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections) {
        log.info(selections);
        selections.ifPresent(personService::deleteAllById);
        return "redirect:people";
    }
    @PostMapping(params = "edit=true")
    public String editPeople(@RequestParam Optional<List<Long>> selections, Model model) {
        log.info(selections);
        selections.ifPresent(longs ->
                model.addAttribute("person", personService.findById(longs.get(0)))
        );
        return "people";
    }
}