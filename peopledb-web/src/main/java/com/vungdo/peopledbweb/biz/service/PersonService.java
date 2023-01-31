package com.vungdo.peopledbweb.biz.service;

import com.vungdo.peopledbweb.biz.model.Person;
import com.vungdo.peopledbweb.data.StorageRepository;
import com.vungdo.peopledbweb.data.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.zip.ZipInputStream;

//control + option + R to config run. (Mac + Intellij
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final StorageRepository fileRepository;

    public PersonService(PersonRepository personRepository, StorageRepository fileRepository) {
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
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
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

    public void importCsvFile(InputStream inputStream) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            zipInputStream.getNextEntry();
            InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader
                    .lines()
                    .skip(1)
                    .limit(100)
                    .map(Person::parse)
                    .forEach(personRepository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}