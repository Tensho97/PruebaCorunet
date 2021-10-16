package com.corunet.prueba.persistence.dao;

import com.corunet.prueba.persistence.entity.PriceEntity;

import java.util.Date;
import java.util.List;


public interface PriceEntityDAO {
    public List<PriceEntity> getPrices();
    public PriceEntity getPrice(Date dateAplication, Long codeProduct, Long idBrand);
}
