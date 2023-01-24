package com.ignacio.davalos.web;

import com.ignacio.davalos.domain.OrderSale;
import com.ignacio.davalos.domain.OrderSaleProduct;
import com.ignacio.davalos.service.OrderSaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/orders/")
@Slf4j
public class OrderSaleController {

    @Autowired
    private OrderSaleService orderSaleService;

    @PostMapping(path = "new")
//    @ResponseStatus(HttpStatus.CREATED)

    public void createOrder(@RequestBody OrderSale orderSale){

        log.info(orderSale.toString());

        orderSaleService.createNew(orderSale);
    }


    @GetMapping(path = "getOrders")
    public Iterable<OrderSale> getOrders(){
        return orderSaleService.getOrders();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return "  fsdafsdfsd " + ex.getMessage();

    }
}
