package com.corunet.prueba.persistence.transformers;

import java.util.List;

public interface BaseEntityTransformer<B,E > {

    public B entityToBusiness (E entity);

    public List<B> entitiesToBusinesses (List<E> entities);
}
