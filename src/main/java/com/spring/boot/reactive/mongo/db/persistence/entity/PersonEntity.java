package com.spring.boot.reactive.mongo.db.persistence.entity;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("people")
public class PersonEntity {

  @Id
  private String id;

  private String firstName;

  private String secondName;

  private String lastName;

  private String secondLastName;

  private LocalDate birthDate;

  private String genre;

  public PersonEntity(String firstName, String secondName, String lastName, String secondLastName,
      LocalDate birthDate, String genre) {
    super();
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.secondLastName = secondLastName;
    this.birthDate = birthDate;
    this.genre = genre;
  }

}
