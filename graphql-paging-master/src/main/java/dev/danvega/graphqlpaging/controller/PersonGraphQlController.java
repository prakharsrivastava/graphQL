package dev.danvega.graphqlpaging.controller;

import dev.danvega.graphqlpaging.model.Person;
import dev.danvega.graphqlpaging.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonGraphQlController {

    private final PersonRepository repository;

    public PersonGraphQlController(PersonRepository repository) {
        this.repository = repository;
    }

    // Returns all people
    @QueryMapping
    public List<Person> allPeople() {
        // Use findAll() from JpaRepository to get a List
        return repository.findAll();
    }

    // Returns paginated people
    @QueryMapping
    public Page<Person> allPeoplePaged(@Argument int page, @Argument int size) {
        PageRequest pr = PageRequest.of(page, size);
        return repository.findAll(pr);
    }
}
