package br.com.tiagomend.rest_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiagomend.rest_api.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}