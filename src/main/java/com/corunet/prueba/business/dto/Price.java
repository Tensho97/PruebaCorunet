package com.corunet.prueba.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Long id;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private Long codeProduct;
    private int priority;
    private double price;
    private String curr;
    private Brand brand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id.equals(price.id) && startDate.equals(price.startDate) && endDate.equals(price.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate);
    }
}
