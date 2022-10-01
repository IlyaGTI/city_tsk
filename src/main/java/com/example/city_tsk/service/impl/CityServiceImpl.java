package com.example.city_tsk.service.impl;

import com.example.city_tsk.exception.NotFoundException;
import com.example.city_tsk.model.City;
import com.example.city_tsk.repository.CityRepository;
import com.example.city_tsk.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City createCity(City city) {
        cityRepository.save(city);
        return city;
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(String.format("Город с названием %s не найден"), name));
    }
}
