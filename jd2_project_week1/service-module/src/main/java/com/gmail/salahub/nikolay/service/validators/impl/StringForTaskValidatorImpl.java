package com.gmail.salahub.nikolay.service.validators.impl;

import com.gmail.salahub.nikolay.service.validators.StringForTaskValidator;

public class StringForTaskValidatorImpl implements StringForTaskValidator {

    private static StringForTaskValidatorImpl instance;

    private StringForTaskValidatorImpl() {
    }

    public static StringForTaskValidatorImpl getInstance() {
        if (instance == null) {
            instance = new StringForTaskValidatorImpl();
        }
        return instance;
    }

    @Override
    public Boolean isValidArguments(String checkedString) {
        if (checkedString.contains(",") & checkedString.contains(":")
                | checkedString.contains(":") & checkedString.contains("|")
                | checkedString.contains("|") & checkedString.contains(",")) {
            return false;
        } else {
            return true;
        }
    }

}
