package com.works.repositories;

import com.works.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {

    Optional<Footballer> findByEmailEqualsIgnoreCase(String email);

    Optional<Footballer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);


}