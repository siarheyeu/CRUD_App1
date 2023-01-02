package ru.siarheyeu.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.groovy.GroovyDynamicElementReader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.siarheyeu.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", )
    }

    public Person show(int id) {

    Person person = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id = ?");

            preparedStatement.setInt (1, id);

           ResultSet resultSet = preparedStatement.executeQuery();

           resultSet.next();

           person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setId(resultSet.getString("name"));
            person.setId(resultSet.getString("email"));
            person.setId(resultSet.getInt("age"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
    }
        public void save(Person person) {

            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO Person VALUES(1, ?, ?, ?)");
            }

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public void update(int id, Person updatePerson){

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?")


                preparedStatement.setString(1, updatedPerson.getName());
                preparedStatement.setInt(2, updatedPerson.getAge());
                preparedStatement.setString(3, updatedPerson.getEmail());
                preparedStatement.setInt(4, updatedPerson.id);

                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
               throwables.printStackTrace();
            }
//
        }

        public void delete(int id) {

    PreparedStatement preparedStatement =null;

            try {
                preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");

                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

}
