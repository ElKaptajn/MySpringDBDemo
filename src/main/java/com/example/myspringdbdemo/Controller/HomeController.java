package com.example.myspringdbdemo.Controller;

import com.example.myspringdbdemo.Model.Person;
import com.example.myspringdbdemo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        List<Person> personList = personService.fetchAll();
        model.addAttribute("persons", personList);
        return "home/index";
    }

    @GetMapping("/create")
    public String create(){
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Person person){
        personService.addPerson(person);
        return "redirect:/";
    }

    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.findPersonById(id));
        return "home/viewOne";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Boolean deleted = personService.deletePersonById(id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.findPersonById(id));
        return "home/update";
    }
    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute Person person){
        personService.updatePerson(person.getId(), person);
        return "redirect:/";
    }
}
