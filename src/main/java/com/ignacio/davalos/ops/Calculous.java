package com.ignacio.davalos.ops;

import com.ignacio.davalos.domain.OrderSale;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class Calculous {

    private int limit;
    private int factor;

    public int calculateRewards(BigDecimal amount, int limit, int factor){

        this.factor = factor;
        this.limit = limit;

        if (amount.intValue() > limit ){
            return amount.subtract(BigDecimal.valueOf(limit)).multiply(BigDecimal.valueOf(factor)).intValue();
        }
        return 0;

    }

    public BigDecimal getTotalAmount(OrderSale orderSale)
    {
        try {
            return BigDecimal.valueOf(orderSale.getOrderSaleProducts()
                    .stream()
                    .filter(p -> p != null)
                    .mapToDouble(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getQuantity())).doubleValue())
                    .sum());
        }catch(Exception e){
            log.error(e.getMessage());
            return BigDecimal.ZERO;
        }

    }


}
