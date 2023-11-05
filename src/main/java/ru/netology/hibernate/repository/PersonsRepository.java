package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PrimaryId;

import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, PrimaryId> {
    @Query("select p from Persons p where p.cityOfLiving = :cityOfLiving")
    List<Persons> findPersonsByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

    //localhost:8080/persons/by-city?city=Moscow
    @Query("select p from Persons p where p.primaryId.age < :age order by p.primaryId.age")
    List<Persons> findPersonsByPrimaryIdAgeLessThanOrderByPrimaryIdAge(@Param("age") int age);

    //http://localhost:8080/persons/by-age?age=18
    @Query("select p from Persons p where p.primaryId.name = :name and p.primaryId.surname = :surname")
    List<Persons> findPersonsByPrimaryId_NameAndPrimaryId_Surname(@Param("name") String name, @Param("surname") String surname);
    //http://localhost:8080/persons/by-name-surname?name=Ivanov&surname=Ivan
}
