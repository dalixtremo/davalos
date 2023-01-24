package com.ignacio.davalos.business;

import com.ignacio.davalos.ops.Reward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.ignacio.davalos.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardTest {

    Reward reward;

    @BeforeEach
    public void ini(){
         reward = new Reward();
    }

    @Test
    public void testOverAHundredReward(){

        assertEquals(40,
        reward.calculateRewards(BigDecimal.valueOf((long)120),firstRewardsLimit, firstRewardsFactor));
    }

    @Test
    public void testOverFivetyReward(){
        assertEquals(70,
        reward.calculateRewards(BigDecimal.valueOf((long)120),secondRewardsLimit, secondRewardsFactor));
    }

}