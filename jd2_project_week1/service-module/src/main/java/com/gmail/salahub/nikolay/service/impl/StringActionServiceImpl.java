package com.gmail.salahub.nikolay.service.impl;

import com.gmail.salahub.nikolay.service.StringActionService;
import com.gmail.salahub.nikolay.service.util.SeparatorSelector;
import com.gmail.salahub.nikolay.service.validators.StringForTaskValidator;
import com.gmail.salahub.nikolay.service.validators.impl.StringForTaskValidatorImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringActionServiceImpl implements StringActionService {

    private static StringActionServiceImpl instance;

    private StringActionServiceImpl() {
    }

    public static StringActionServiceImpl getInstance() {
        if (instance == null) {
            instance = new StringActionServiceImpl();
        }
        return instance;
    }

    private StringForTaskValidator stringForTaskValidator = StringForTaskValidatorImpl.getInstance();

    @Override
    public int add(String numbers) {
        if (stringForTaskValidator.isValidArguments(numbers)) {
            String separator = SeparatorSelector.getSeparatorOfNumbers(numbers);
            int[] numberInt = Arrays.stream(numbers.split(separator))
                    .mapToInt(Integer::parseInt).toArray();

            return Arrays.stream(numberInt).sum();
        } else {
            throw new IllegalArgumentException("the file contains two different delimiters, you must select only one");
        }
    }
}
