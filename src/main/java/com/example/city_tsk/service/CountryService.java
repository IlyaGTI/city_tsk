package com.example.city_tsk.service;

import com.example.city_tsk.dto.CountryDTO;
import com.example.city_tsk.model.Country;

import java.util.List;

public interface CountryService {

    Country createCountry(CountryDTO countryDTO);

    CountryDTO getByName(String name);

    List<CountryDTO> getAll();
}
