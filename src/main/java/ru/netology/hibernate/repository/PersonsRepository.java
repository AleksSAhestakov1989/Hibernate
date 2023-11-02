package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PrimaryId;

import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, PrimaryId> {
    List<Persons> findPersonsByCityOfLiving(String city);

    List<Persons> findPersonsByPrimaryIdAgeLessThanOrderByPrimaryIdAge(int age);


    List<Persons> findPersonsByPrimaryIdNameAndPrimaryIdSurname(String name, String surname);
}
