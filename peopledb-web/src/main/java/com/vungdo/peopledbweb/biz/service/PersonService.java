package com.vungdo.peopledbweb.biz.service;

import com.vungdo.peopledbweb.biz.model.Person;
import com.vungdo.peopledbweb.data.LocalFileRepository;
import com.vungdo.peopledbweb.data.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Optional;

//control + option + R to config run. (Mac + Intellij
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final LocalFileRepository fileRepository;

    public PersonService(PersonRepository personRepository, LocalFileRepository fileRepository) {
        this.personRepository = personRepository;
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Person save(Person person, InputStream inputStream) {
        Person savedPerson = personRepository.save(person);
        fileRepository.save(person.getPhotoFileName(), inputStream);
        return savedPerson;
    }

    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public void deleteAllById(Iterable<Long> ids) {
        Iterable<String> filenames = personRepository.findFileNamesByIds(ids);
        personRepository.deleteAllById(ids);
        fileRepository.deleteByFilenames(filenames);
    }

    public Resource getResource(String fileName) {
        return fileRepository.getResource(fileName);
    }
}
