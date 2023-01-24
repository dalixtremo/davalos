package com.ignacio.davalos.ops;

import java.math.BigDecimal;

public class Reward {

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


}
