package com.example.city_tsk.controller;

import com.example.city_tsk.dto.CountryDTO;
import com.example.city_tsk.model.City;
import com.example.city_tsk.model.Country;
import com.example.city_tsk.model.Region;
import com.example.city_tsk.service.CityService;
import com.example.city_tsk.service.CountryService;
import com.example.city_tsk.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final CountryService countryService;
    private final CityService cityService;
    private final RegionService regionService;

    @GetMapping("/country/all")
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/country/new")
    public ResponseEntity<Country> createCountry(@RequestBody CountryDTO countryDTO) {
        return new ResponseEntity<>(countryService.createCountry(countryDTO), HttpStatus.CREATED);
    }

    @PostMapping("/country/{name}")
    public ResponseEntity<CountryDTO> getCountryByName(@PathVariable(name = "name") String name) {
        return new ResponseEntity<>(countryService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/region/new")
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        return new ResponseEntity<>(regionService.createRegion(region), HttpStatus.CREATED);
    }

    @PostMapping("/city/new")
    public ResponseEntity<City> createCapital(@RequestBody City city) {
        return new ResponseEntity<>(cityService.createCity(city), HttpStatus.CREATED);
    }

}
