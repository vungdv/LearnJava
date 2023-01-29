package com.vungdo.peopledbweb.data;

import com.vungdo.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonDataLoader implements ApplicationRunner {
    private final PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public void run(ApplicationArguments args) {
        if (personRepository.count() == 0){
            //^ + command + G: to use multiple cursors to edit multiple lines at once
            List<Person> people = List.of(
                    new Person(1L, "Vung", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(2L, "Vung 2", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(4L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(5L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(6L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(7L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(8L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(9L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(10L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(11L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(12L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(13L, "Vung 4", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(14L, "Vung 4", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null),
                    new Person(15L, "Vung 4", "Do", LocalDate.of(1999, 1, 1), "Dummy@gmail.com", BigDecimal.valueOf(1000), null)
            );
            personRepository.saveAll(people);
        }
    }
}
