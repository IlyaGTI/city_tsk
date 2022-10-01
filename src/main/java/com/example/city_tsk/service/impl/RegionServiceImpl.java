package com.example.city_tsk.service.impl;

import com.example.city_tsk.exception.NotFoundException;
import com.example.city_tsk.model.Region;
import com.example.city_tsk.repository.RegionRepository;
import com.example.city_tsk.service.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Region createRegion(Region region) {
        regionRepository.save(region);
        return region;
    }

    @Override
    public Region findByName(String name) {
        return regionRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(String.format("Регион с названием %s не найден"), name));
    }
}
