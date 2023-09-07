package com.spring.boot.reactive.mongo.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ReactiveMongoDBConfig {

  // ------------------
  // Private Attributes
  // ------------------

  private final Environment env;

  // --------------
  // Public Methods
  // --------------

  @Bean
  ReactiveMongoTemplate reactiveMongoTemplate() {
    ReactiveMongoTemplate mongoTemplate = new ReactiveMongoTemplate(mongoClient(), databaseName());
    return mongoTemplate;
  }

  // ---------------
  // Private Methods
  // ---------------

  private MongoClient mongoClient() {

    StringBuilder connectionUrl = new StringBuilder();
    connectionUrl.append("mongodb://");
    connectionUrl.append(env.getProperty("spring.data.mongodb.username"));
    connectionUrl.append(":");
    connectionUrl.append(env.getProperty("spring.data.mongodb.password"));
    connectionUrl.append("@");
    connectionUrl.append(env.getProperty("spring.data.mongodb.host"));
    connectionUrl.append(":");
    connectionUrl.append(env.getProperty("spring.data.mongodb.port"));
    connectionUrl.append("/");
    connectionUrl.append(env.getProperty("spring.data.mongodb.database"));

    MongoClient mClient = MongoClients.create(connectionUrl.toString());
    return mClient;
  }

  private String databaseName() {
    return env.getProperty("spring.data.mongodb.database");
  }

}
