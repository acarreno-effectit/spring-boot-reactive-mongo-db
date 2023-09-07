package com.spring.boot.reactive.mongo.db.service;

import com.spring.boot.reactive.mongo.db.persistence.entity.PersonEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PeopleService {

  Mono<PersonEntity> getPersonById(String id);

  Flux<PersonEntity> getPeople();

  Mono<PersonEntity> savePerson(PersonEntity person);

  Mono<PersonEntity> updatePerson(String id, PersonEntity Person);

  Mono<Void> deletePerson(String id);
}
