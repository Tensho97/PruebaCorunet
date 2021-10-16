package com.corunet.prueba.persistence.dao.impl;

import com.corunet.prueba.persistence.dao.PriceEntityDAO;
import com.corunet.prueba.persistence.entity.BrandEntity;
import com.corunet.prueba.persistence.entity.BrandEntity$;
import com.corunet.prueba.persistence.entity.PriceEntity;
import com.corunet.prueba.persistence.entity.PriceEntity$;
import com.corunet.prueba.persistence.transformers.PriceEntityTransformer;
import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.projection.Projection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.JoinType;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.*;

@Repository
public class PriceEntityDAOImpl  implements PriceEntityDAO {

    @Autowired
    private JPAStreamer jpaStreamer;

    @Override
    public List<PriceEntity> getPrices() {
        return jpaStreamer.stream(PriceEntity.class)
                .collect(Collectors.toList());
    }

    @Override
    public PriceEntity getPrice(Date dateAplication, Long codeProduct, Long idBrand) {
        List<PriceEntity> pricesEntity = jpaStreamer.stream(of(PriceEntity.class).joining(PriceEntity$.brand))
                .filter(PriceEntity$.codeProduct.equal(codeProduct)
                        .and(PriceEntity$.startDate.lessOrEqual(dateAplication))
                        .and(PriceEntity$.endDate.greaterOrEqual(dateAplication))
                ).collect(Collectors.toList());

        return pricesEntity
                .stream()
                .filter(price -> price.getBrand().getId().compareTo(idBrand) == 0)
                .max(Comparator.comparing(PriceEntity::getPriority)).get();

    }
}
