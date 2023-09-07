package com.spring.boot.reactive.mongo.db.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.reactive.mongo.db.persistence.entity.PersonEntity;
import com.spring.boot.reactive.mongo.db.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
public class WebController {
  
  private final PersonRepository personRepository;
  
  @GetMapping(value = "/people", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<PersonEntity> getPeople() {
      return personRepository.findAll().subscribeOn(Schedulers.boundedElastic());
  }

}
