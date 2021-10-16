package com.corunet.prueba.business.service;

import com.corunet.prueba.business.dto.Price;

import java.util.Date;
import java.util.List;

public interface PriceService {

    public List<Price> getPrices();
    public Price getPrice (Date dateAplication, Long idPrice, Long idBrand);
}
