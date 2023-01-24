package com.vungdo.peopledb.repository;

import javax.swing.text.html.Option;
import java.sql.*;
import java.time.ZoneId;
import java.util.Optional;

public class PeopleRepository {
    private Connection connection;
    public PeopleRepository(Connection connection) {
        this.connection = connection;
    }

    public Person save(Person person) {
        String sql = "INSERT INTO people (first_name, last_name, dob) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setTimestamp(3, Timestamp.valueOf(person.getDob().withZoneSameInstant(ZoneId.of("+0")).toLocalDateTime()));
            var recordAffected = ps.executeUpdate();
            System.out.printf("Record affected: %d%n", recordAffected);
            ResultSet resultSet = ps.getGeneratedKeys();
            while (resultSet.next()) {
                person.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public Optional<Person> findById(Long id) {
        Person person = null;
        try{
            var ps = connection.prepareStatement("SELECT * FROM people WHERE id = ?");
            ps.setLong(1, id);
            var rs = ps.executeQuery();
            while(rs.next()) {
                person = new Person(rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getTimestamp("dob").toLocalDateTime().atZone(ZoneId.of("+0")));
                person.setId(rs.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(person);
    }

    public long count() {
        try {
            var ps = connection.prepareStatement("SELECT COUNT(*) FROM people");
            var rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void delete(Person savedPerson) {
        try {
            var ps = connection.prepareStatement("DELETE FROM people WHERE id = ?");
            ps.setLong(1, savedPerson.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}