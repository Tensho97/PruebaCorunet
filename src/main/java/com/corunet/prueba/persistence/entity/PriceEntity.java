package com.corunet.prueba.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRICES")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "price_list")
    private int priceList;
    @Column(name = "product_id")
    private Long codeProduct;
    @Column(name = "priority")
    private int priority;
    @Column(name = "price")
    private double price;
    @Column(name = "curr")
    private String curr;
    @ManyToOne
    private BrandEntity brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public Long getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Long codeProduct) {
        this.codeProduct = codeProduct;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}