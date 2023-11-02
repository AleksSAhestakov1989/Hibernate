package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.service.PersonsService;

import java.util.List;

@AllArgsConstructor
@RestController
public class PersonsController {
    private PersonsService service;

    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Persons> getPersonByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }
    // Запрос localhost:8080/persons/by-city?city=Moscow

    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Persons> getPersonByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }
    // Запрос localhost:8080/persons/by-age?age=19

    @GetMapping("/persons/by-name-surname")
    @ResponseBody
    public List<Persons> getPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return service.getPersonByNameAndSurname(name, surname);
    }
    // Запрос localhost:8080/persons/by-name-surname?name=Ivan&surname=Ivanov
}
