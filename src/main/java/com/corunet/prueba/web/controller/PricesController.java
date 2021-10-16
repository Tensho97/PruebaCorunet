package com.corunet.prueba.web.controller;

import com.corunet.prueba.business.dto.Price;
import com.corunet.prueba.business.service.PriceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "zara")
public class PricesController {

    @Autowired
    private PriceService priceService;

    @GetMapping(value = "/prices")
    public ResponseEntity<List<Price>> getPrices(){
        List<Price> prices = priceService.getPrices();
        if(prices != null){
            return new ResponseEntity<List<Price>>(prices, HttpStatus.OK);
        }
        return new ResponseEntity<List<Price>>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/price/{date}/{idPrice}/{idBrand}")
    public ResponseEntity<Price> getPrice(@PathVariable  String date,
                                          @PathVariable("idPrice") Long idPrice,
                                          @PathVariable("idBrand") Long idBrand) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateFormat = format.parse(date);
        Price price = priceService.getPrice(dateFormat, idPrice, idBrand);
        return new ResponseEntity<Price>(price, HttpStatus.OK);
    }
}
