package com.example.city_tsk.service;

import com.example.city_tsk.model.Region;

public interface RegionService {

    Region createRegion(Region region);

    Region findByName(String name);
}
