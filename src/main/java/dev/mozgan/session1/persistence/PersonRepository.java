package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Person.PersonId> {

    @Query("SELECT p FROM Person p WHERE p.lastName ILIKE 'Schmidt'")
    List<Person> findSchmidts();

    Optional<Person> findByPersonId(Person.PersonId personId);
}
