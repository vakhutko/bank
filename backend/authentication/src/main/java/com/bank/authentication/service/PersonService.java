package com.bank.authentication.service;

import com.bank.authentication.entity.Person;
import com.bank.authentication.repository.PersonRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }
}
