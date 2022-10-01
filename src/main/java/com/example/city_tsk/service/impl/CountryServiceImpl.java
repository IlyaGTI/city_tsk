package com.example.city_tsk.service.impl;

import com.example.city_tsk.dto.CountryDTO;
import com.example.city_tsk.dto.mapper.CountryMapper;
import com.example.city_tsk.exception.NotFoundException;
import com.example.city_tsk.model.Country;
import com.example.city_tsk.repository.CountryRepository;
import com.example.city_tsk.repository.RegionRepository;
import com.example.city_tsk.service.CityService;
import com.example.city_tsk.service.CountryService;
import com.example.city_tsk.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    private final CityService cityService;
    private final RegionService regionService;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper, CityService cityService, RegionService regionService) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
        this.cityService = cityService;
        this.regionService = regionService;
    }

    @Override
    public Country createCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setCapital(cityService.findByName(countryDTO.getCapital()));
        country.setRegions(regionService.findByName(countryDTO.getRegion()));
        country.setArea(countryDTO.getArea());
        country.setName(countryDTO.getName());
        country.setCode(countryDTO.getCode());
        country.setPopulation(countryDTO.getPopulation());
        countryRepository.save(country);
        return country;
    }

    @Override
    public CountryDTO getByName(String name) {
        return countryMapper.CountryToCountryDTO(countryRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(String.format("Страна с название %s не найдена"), name)));
    }

    @Override
    public List<CountryDTO> getAll() {
        return countryMapper.listCountryToListCountryDto(countryRepository.findAll());
    }



}
