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
}
