package com.example.city_tsk.dto.mapper;

import com.example.city_tsk.dto.CountryDTO;
import com.example.city_tsk.model.Country;
import com.example.city_tsk.model.Region;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    public CountryDTO CountryToCountryDTO(Country country) {

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setArea(country.getArea());
        countryDTO.setCapital(country.getCapital().getName());
        countryDTO.setName(country.getName());
        countryDTO.setPopulation(country.getPopulation());
        countryDTO.setRegion(country.getRegions().getName());

        return countryDTO;
    }

    public List<CountryDTO> listCountryToListCountryDto(List<Country> countries){
        return countries.stream()
                .map(c -> new CountryDTO(c.getName(),
                        c.getCapital().getName(),
                        c.getRegions().getName(),
                        c.getCode(),  c.getPopulation(),
                        c.getArea()))
                .collect(Collectors.toList());
    }

}
