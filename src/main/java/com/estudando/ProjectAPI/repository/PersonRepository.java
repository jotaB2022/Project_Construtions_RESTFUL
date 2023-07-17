package com.estudando.ProjectAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudando.ProjectAPI.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
