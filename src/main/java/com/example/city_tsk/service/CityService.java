package com.example.city_tsk.service;

import com.example.city_tsk.model.City;

public interface CityService {

    City createCity(City city);

    City findByName(String name);

}
