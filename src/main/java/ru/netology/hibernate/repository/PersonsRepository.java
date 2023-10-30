package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;

import java.util.List;

@Repository
public class PersonsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        var query = entityManager.createQuery(
                "select p from Persons p where p.cityOfLiving =:city");
        query.setParameter("city", city);
        return query.getResultList();

    }

    @Transactional
    public void create(Persons persons) {
        entityManager.persist(persons);
    }

}
