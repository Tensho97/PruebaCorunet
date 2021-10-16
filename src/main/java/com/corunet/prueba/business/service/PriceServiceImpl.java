package com.corunet.prueba.business.service;

import com.corunet.prueba.business.dto.Price;
import com.corunet.prueba.persistence.dao.PriceEntityDAO;
import com.corunet.prueba.persistence.transformers.PriceEntityTransformer;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
    private PriceEntityDAO priceEntityDAO;

    @Autowired
    private JPAStreamer jpaStreamer;
    @Autowired
    private PriceEntityTransformer priceEntityTransformer;


    @Override
    @Transactional(readOnly = true)
    public List<Price> getPrices() {
        List<Price>  prices =  priceEntityTransformer.entitiesToBusinesses(priceEntityDAO.getPrices());
        return prices;
    }

    @Override
    @Transactional(readOnly = true)
    public Price getPrice(Date dateAplication, Long idPrice, Long idBrand) {
        return priceEntityTransformer.entityToBusiness(priceEntityDAO.getPrice(dateAplication,idPrice,idBrand));
    }
}
