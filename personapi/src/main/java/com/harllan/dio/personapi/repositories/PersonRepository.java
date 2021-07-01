package com.harllan.dio.personapi.repositories;

import com.harllan.dio.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
