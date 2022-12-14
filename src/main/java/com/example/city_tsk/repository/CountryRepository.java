package com.example.city_tsk.repository;

import com.example.city_tsk.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

   Optional<Country> findByName(String name);


}
