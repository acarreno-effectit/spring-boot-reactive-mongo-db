package com.spring.boot.reactive.mongo.db.service.impl;

import org.springframework.stereotype.Service;
import com.spring.boot.reactive.mongo.db.persistence.entity.PersonEntity;
import com.spring.boot.reactive.mongo.db.persistence.repository.PersonRepository;
import com.spring.boot.reactive.mongo.db.service.PeopleService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

  private final PersonRepository personRepository;

  @Override
  public Mono<PersonEntity> getPersonById(String id) {
    return personRepository.findById(id);
  }

  @Override
  public Flux<PersonEntity> getPeople() {

    personRepository.findAll().subscribe(item -> System.out.println(item.getFirstName()));

    return personRepository.findAll();
  }

  @Override
  public Mono<PersonEntity> savePerson(PersonEntity person) {
    return personRepository.save(person);
  }

  @Override
  public Mono<PersonEntity> updatePerson(String id, PersonEntity Person) {
    return personRepository.findById(id).flatMap(user -> {
      Person.setId(user.getId());
      return personRepository.save(Person);
    });
  }

  @Override
  public Mono<Void> deletePerson(String id) {
    return personRepository.deleteById(id);
  }

}
