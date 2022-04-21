package com.example.myspringdbdemo.Repository;

import com.example.myspringdbdemo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo {
    @Autowired
    JdbcTemplate template;
    public List<Person> fetchAll(){
        String sql ="SELECT * FROM persons";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

    public void addPerson(Person person){
        String sql = "INSERT INTO persons (id, first_name, last_name) VALUES(?, ?, ?)";
        template.update(sql, person.getId(), person.getFirst_name(), person.getLast_name());
    }

    public Person findPersonById(int id){
        String sql="SELECT * FROM persons WHERE id=?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person person = template.queryForObject(sql, rowMapper, id);
        return person;
    }

    public Boolean deletePersonById(int id){
        String sql = "DELETE FROM persons WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void updatePerson(int id, Person person){
        String sql = "UPDATE persons SET first_name = ?, last_name = ? WHERE id = ?";
        template.update(sql, person.getFirst_name(), person.getLast_name(), person.getId());
    }

}
