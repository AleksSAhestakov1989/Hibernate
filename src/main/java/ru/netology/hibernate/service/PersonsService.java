package ru.netology.hibernate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.PersonsRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonsService {
    private PersonsRepository repository;

    public List<Persons> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
