package com.ledsonsilva.bravi.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceBracketsUtilTest {

    @Test
    public void isFalseBalanceBracketsFirstSequenceIncorrect() {

        String brackets = "[]{()";
        Assert.assertFalse(BalanceBracketsUtil.isValid(brackets));
    }

    @Test
    public void isFalseBalanceBracketsSecondSequenceIncorrect() {

        String brackets = "[{)]";
        Assert.assertFalse(BalanceBracketsUtil.isValid(brackets));
    }

    @Test
    public void isTrueBalanceBracketsFirstSequenceCorrect() {

        String brackets = "(){}[]";
        Assert.assertTrue(BalanceBracketsUtil.isValid(brackets));
    }

    @Test
    public void isTrueBalanceBracketsSecondSequenceCorrect() {

        String brackets = "[{()}](){}";
        Assert.assertTrue(BalanceBracketsUtil.isValid(brackets));
    }
}
