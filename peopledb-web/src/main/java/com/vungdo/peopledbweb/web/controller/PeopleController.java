package com.vungdo.peopledbweb.web.controller;

import com.vungdo.peopledbweb.biz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @GetMapping
    public String getPeople(Model model) {
        List<Person> people = List.of(
                new Person(1L, "Vung", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(2L, "Vung 2", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(3L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(4L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(5L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(6L, "Vung 3", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000)),
                new Person(7L, "Vung 4", "Do", LocalDate.of(1999, 1, 1), BigDecimal.valueOf(1000))
        );
        model.addAttribute("people", people);
        return "people";
    }
}
