package com.gmail.salahub.nikolay;

import com.gmail.salahub.nikolay.service.StringActionService;
import com.gmail.salahub.nikolay.service.impl.StringActionServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class StringActionServiceTest {

    private StringActionService stringAction = StringActionServiceImpl.getInstance();

    @Test
    public void shouldStringSummed() {
        String testString = "1,2";
        int result = stringAction.add(testString);
        Assert.assertEquals(3, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shodVoidThrowException() {
        String invalidNumberString = "1:2,3";
        int result = stringAction.add(invalidNumberString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shodVoidThrowExceptionIfComesStringWithMoreThenTwoNumbers(){
        String invalidString = "1,2,3";
        int result = stringAction.add(invalidString);
    }
}
