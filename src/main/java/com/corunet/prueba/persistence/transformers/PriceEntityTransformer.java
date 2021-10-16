package com.corunet.prueba.persistence.transformers;

import com.corunet.prueba.business.dto.Brand;
import com.corunet.prueba.business.dto.Price;
import com.corunet.prueba.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceEntityTransformer implements BaseEntityTransformer<Price, PriceEntity>{
    @Override
    public Price entityToBusiness(PriceEntity entity) {

        Price price = new Price();
        price.setId(entity.getId());
        price.setStartDate(entity.getStartDate());
        price.setEndDate(entity.getEndDate());
        price.setPriceList(entity.getPriceList());
        price.setCodeProduct(entity.getCodeProduct());
        price.setPriority(entity.getPriority());
        price.setCurr(entity.getCurr());

        Brand brand = new Brand();
        brand.setName(entity.getBrand().getName());
        brand.setId(entity.getBrand().getId());

        price.setBrand(brand);

        return price;
    }

    @Override
    public List<Price> entitiesToBusinesses(List<PriceEntity> entities) {
        return entities.stream().map(this::entityToBusiness).collect(Collectors.toList());
    }
}
