package com.ignacio.davalos.service;


import com.ignacio.davalos.domain.Customer;
import com.ignacio.davalos.domain.OrderSale;
import com.ignacio.davalos.ops.Calculous;
import com.ignacio.davalos.repo.OrderSaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.ignacio.davalos.utils.Constants.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class OrderSaleService {

    @Autowired
    private OrderSaleRepository orderSaleRepository;


    public void createNew(OrderSale orderSale){

        Calculous calculous = new Calculous();

        orderSale.setAmount(calculous.getTotalAmount(orderSale));
        orderSale.setRewards(calculous.calculateRewards(orderSale.getAmount(),firstRewardsLimit,firstRewardsFactor)
                +
                calculous.calculateRewards(orderSale.getAmount(),secondRewardsLimit,secondRewardsFactor)
        );

        log.debug( orderSale.toString());

        orderSaleRepository.save(orderSale);
    }

    public Iterable<OrderSale> getOrders(){
        return orderSaleRepository.findAll();
    }


    public Map<Customer, IntSummaryStatistics> getReport(){

        LocalDateTime start = LocalDateTime.now().minusMonths(3);
        LocalDateTime end = LocalDateTime.now();

        System.out.println(start);
        System.out.println(end);

        Map<Customer, IntSummaryStatistics> sum = StreamSupport.stream(orderSaleRepository.findAll().spliterator(),false)
                .filter(os -> os.getTransactionDate().before(Timestamp.valueOf(end)))
                .filter(os -> os.getTransactionDate().after(Timestamp.valueOf(start)))
                .collect(Collectors.groupingBy(OrderSale::getCustomerId, Collectors.summarizingInt(OrderSale::getRewards)));
    return sum;
    }

}
