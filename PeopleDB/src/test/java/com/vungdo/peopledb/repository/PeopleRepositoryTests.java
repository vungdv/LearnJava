package com.vungdo.peopledb.repository;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleRepositoryTests {

    private Connection connection;
    private PeopleRepository repo;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager
                .getConnection("jdbc:h2:~/peopletest;DB_CLOSE_DELAY=-1"
                        .replace("~", System.getProperty("user.home")));
        connection.setAutoCommit(false);
        repo = new PeopleRepository(this.connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if(connection != null)
            connection.close();
    }

    @Test
    public void canSaveSinglePerson() {
        //Arrange
        Person john = new Person("John", "Doe",
                ZonedDateTime.of(1990,
                        1,
                        1,
                        0,
                        0,
                        0,
                        0,
                        ZoneId.of("-6")));
        //Act
        Person savedPerson = repo.save(john);

        //Assert
        assertThat(savedPerson.getId()).isNotNull();
    }

    @Test
    public void canSaveTwoPeople() {
        //Arrange
        //search for java system property for document.
        Person john = new Person("John", "Doe",
                ZonedDateTime.of(1990,
                        1,
                        1,
                        0,
                        0,
                        0,
                        0,
                        ZoneId.of("-6")));
        Person vung = new Person("Vung", "Do",
                ZonedDateTime.of(1990,
                        11,
                        1,
                        0,
                        0,
                        0,
                        0,
                        ZoneId.of("-6")));
        //Act
        Person savedPerson1 = repo.save(john);
        //duplicate line: command + d
        Person savedPerson2 = repo.save(vung);
        //Assert
        assertThat(savedPerson1.getId()).isNotEqualTo(savedPerson2.getId());
    }

    @Test
    public void canFindPersonById(){
        var savedPerson = repo.save(new Person("Chill", "Ta",
                ZonedDateTime.of(1990,
                        1,
                        1,
                        0,
                        0,
                        0,
                        0,
                        ZoneId.of("-6"))));
        var foundPerson = repo.findById(savedPerson.getId());
        assertThat(foundPerson.get()).isEqualTo(savedPerson);
    }
    @Test
    public void testPersonIdNotFound(){
        Optional<Person> foundPerson = repo.findById(-1L);
        assertThat(foundPerson).isEmpty();
    }
    @Test
    public void canDeletePerson(){
        var savedPerson = repo.save(new Person("Chill", "Ta",
                ZonedDateTime.of(1990,
                        1,
                        1,
                        0,
                        0,
                        0,
                        0,
                        ZoneId.of("-6"))));
        long startCount = repo.count();
        repo.delete(savedPerson);
        long endCount = repo.count();
        assertThat(endCount).isEqualTo(startCount - 1);
    }
}
