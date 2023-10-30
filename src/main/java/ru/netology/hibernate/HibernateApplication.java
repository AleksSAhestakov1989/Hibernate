package ru.netology.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PrimaryId;
import ru.netology.hibernate.repository.PersonsRepository;

@Builder
@RequiredArgsConstructor
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
    private final PersonsRepository personsRepository;


    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        var primaryId = PrimaryId.builder()
                .age(18)
                .surname("Petr")
                .name("Petrov")
                .build();

        createPersons(primaryId);

    }

    public void createPersons(PrimaryId primaryId) {
        var persons = Persons.builder()
                .primaryId(primaryId)
                .phoneNumber("000-003")
                .cityOfLiving("Moscow")
                .build();
        personsRepository.create(persons);

    }


}





