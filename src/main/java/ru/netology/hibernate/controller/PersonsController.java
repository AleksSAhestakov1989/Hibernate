package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.service.PersonsService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@AllArgsConstructor
@RestController
public class PersonsController {
    private PersonsService service;

    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Persons> getPersonByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }
    // Запрос localhost:8080/persons/by-city?city=Moscow

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Persons> getPersonByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }

    // Запрос localhost:8080/persons/by-age?age=19
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/persons/by-name-surname")
    @ResponseBody
    public List<Persons> getPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return service.getPersonByNameAndSurname(name, surname);
    }
    // Запрос localhost:8080/persons/by-name-surname?name=Ivanov&surname=Ivan

    @PostAuthorize("#username == authentication.principal.username")
    @GetMapping("/persons/phone-by-name")
    @ResponseBody
    public String getPhoneNumberByName(String username) {
        return service.getPhoneByName(username);
    }

    // Запрос localhost:8080/persons/phone-by-name?username=Petrov
    @GetMapping("/persons")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE') and #username == authentication.principal.username")
    @ResponseBody
    public String greetingUser(String username) {
        return "Hi, " + username;
    }
    // Запрос localhost:8080/persons?username=Petrov
}
