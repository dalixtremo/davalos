package com.ignacio.davalos.service;


import com.ignacio.davalos.domain.OrderSale;
import com.ignacio.davalos.repo.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSaleService {

    @Autowired
    private OrderSaleRepository orderSaleRepository;


    public void createNew(OrderSale orderSale){



        orderSaleRepository.save(orderSale);
    }

    public Iterable<OrderSale> getOrders(){
       return orderSaleRepository.findAll();
    }



}
