package dev.danvega.graphqlpaging.repository;

import dev.danvega.graphqlpaging.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
