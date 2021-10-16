package com.corunet.prueba;
import com.corunet.prueba.business.dto.Price;
import com.corunet.prueba.business.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PricesTest {

    @Autowired
    private PriceService priceService;

    @Test
    public void getPrices(){
        List<Price> prices =priceService.getPrices();
        assertThat(prices.size()).isEqualTo(4);
    }
    @Test
    public void case1() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Price price = priceService.getPrice(formatter.parse("2020-06-14 10:00:00"), 35455L, 1L);
        assertThat(price.equals(causes(1)));
    }
    @Test
    public void case2() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Price price = priceService.getPrice(formatter.parse("2020-06-14 16:00:00"), 35455L, 1L);
        assertThat(price.equals(causes(2)));
    }
    @Test
    public void case3() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Price price = priceService.getPrice(formatter.parse("2020-06-14 21:00:00"), 35455L, 1L);
        assertThat(price.equals(causes(3)));
    }
    @Test
    public void case4() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Price price = priceService.getPrice(formatter.parse("2020-06-15 10:00:00"), 35455L, 1L);
        assertThat(price.equals(causes(4)));
    }
    @Test
    public void case5() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Price price = priceService.getPrice(formatter.parse("2020-06-16 21:00:00"), 35455L, 1L);
        assertThat(price.equals(causes(5)));
    }

    public static Price causes(int option) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        switch(option){
            case 1: Price price = new Price();
                price.setId(1L);
                price.setStartDate(formatter.parse("2020-06-14 00:00:00"));
                price.setEndDate(formatter.parse("2020-12-31 23:59:59"));
                return price;

            case 2:
                Price price2= new Price();
                price2.setId(2L);
                price2.setStartDate(formatter.parse("2020-06-14 15:00:00"));
                price2.setEndDate(formatter.parse("2020-06-14 18:30:00"));
                return price2;

            case 3:
                Price price3 = new Price();
                price3.setId(3L);
                price3.setStartDate(formatter.parse("2020-06-14 00:00:00"));
                price3.setEndDate(formatter.parse("2020-12-31 23:59:59"));
                return price3;

            case 4:
                Price price4 = new Price();
                price4.setId(4L);
                price4.setStartDate(formatter.parse("2020-06-15 00:00:00"));
                price4.setEndDate(formatter.parse("2020-06-15 11:00:00"));
                return price4;

            case 5:
                Price price5 = new Price();
                price5.setId(5L);
                price5.setStartDate(formatter.parse("2020-06-15 16:00:00"));
                price5.setEndDate(formatter.parse("2020-12-31 23:59:59"));
                return price5;

        }
        return null;
    }









}
