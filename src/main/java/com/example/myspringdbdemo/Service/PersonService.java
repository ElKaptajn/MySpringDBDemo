package com.example.myspringdbdemo.Service;

import com.example.myspringdbdemo.Model.Person;
import com.example.myspringdbdemo.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;
    public List<Person> fetchAll(){
        return personRepo.fetchAll();
    }

    public void addPerson(Person person){
        personRepo.addPerson(person);
    }

    public Person findPersonById(int id){
        return personRepo.findPersonById(id);
    }

    public boolean deletePersonById(int id){
        return personRepo.deletePersonById(id);
    }
    public void updatePerson(int id, Person person){
        personRepo.updatePerson(id, person);
    }


}
