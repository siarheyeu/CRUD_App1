package ru.siarheyeu.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.siarheyeu.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
private static final String USERNAME = "postgres";
private static final String PASSWORD = "Qd197!@#$asd";

private static Connection connection;

static {
    try{
        Class.forName("org.postgresql.Driver");
        }
    catch (ClassNotFoundException e){
        e.printStackTrace();
    }

    try{
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    catch (SQLException throwables){
        throwables.printStackTrace();
    }
}

    public List<Person> index(){
      List<Person> people = new ArrayList<>();

      try{
          Statement statement = connection.createStatement();
          String SQL = "SELECT * FROM Person";
          ResultSet resultSet = statement.executeQuery(SQL);

          while (resultSet.next()){
              Person person = new Person();

              person.setId (resultSet.getInt("id"));
              person.setName (resultSet.getString("name"));
              person.setEmail (resultSet.getString("email"));
              person.setAge (resultSet.getInt("age"));

              people.add(person);
          }

      } catch (SQLException throwables){
          throwables.printStackTrace();
      }
    }

    public Person show(int id) {
        //   return people.stream().filter(person -> person.getId() == id).findAny().orElse((null);
        return null;
    }
        public void save(Person person) {
//            person.getId(++PEOPLE_COUNT);
//            people.add(person);

            try {
                Statement statement = connection.createStatement();
                String SQL = "INSERT INTO Person VALUES(" + 1 + "," + person.getName() + "'," + person.getAge() +  "'," + person.getEmail() + "')";

                // INSERT INTO Person VALUES(1, 'Tom', 18, 'asdf@mail.ru')

                statement.executeUpdate(SQL);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public void update(int id, Person updatePerson){
//            Person personToBeUpdated = show(id);
//
//            personToBeUpdated.setName(updatePeson.getName());
//            personToBeUpdated.setAge(updatedPerson.getAge());
//            personToBeUpdated.setEmail(updatedPerson.getEmail());
        }

        public void delete(int id) {
            people.removeIf(p -> p.getId() == id);
        }

}
