package com.spring.boot.reactive.mongo.db.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.spring.boot.reactive.mongo.db.persistence.entity.PersonEntity;

public interface PersonRepository extends ReactiveMongoRepository<PersonEntity, String> {

}
