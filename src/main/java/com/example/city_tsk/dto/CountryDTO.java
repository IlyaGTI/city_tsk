package com.example.city_tsk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {

    private String name;

    private String capital;

    private String region;

    private String code;

    private Long population;

    private Double area;

}
