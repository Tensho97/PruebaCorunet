package com.corunet.prueba.business.dto;

import lombok.Data;

import java.util.List;

@Data
public class Brand {
    private Long id;
    private String name;
    private List<Price> prices;
}
