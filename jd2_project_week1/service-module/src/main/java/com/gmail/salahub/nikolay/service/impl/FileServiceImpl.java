package com.gmail.salahub.nikolay.service.impl;

import com.gmail.salahub.nikolay.repository.FileRepository;
import com.gmail.salahub.nikolay.repository.impl.FileRepositoryImpl;
import com.gmail.salahub.nikolay.service.FileService;
import com.gmail.salahub.nikolay.service.util.LimitNumber;
import com.gmail.salahub.nikolay.service.util.SeparatorSelector;
import com.gmail.salahub.nikolay.service.validators.StringForTaskValidator;
import com.gmail.salahub.nikolay.service.validators.impl.StringForTaskValidatorImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {

    private static FileServiceImpl instance;

    private FileServiceImpl() {
    }

    public static FileServiceImpl getInstance() {
        if (instance == null) {
            instance = new FileServiceImpl();
        }
        return instance;
    }

    private FileRepository fileRepository = FileRepositoryImpl.getInstance();
    private StringForTaskValidator stringForTaskValidator = StringForTaskValidatorImpl.getInstance();

    @Override
    public String getValidStringFromFile(String fileName) throws IOException {

        List<String> strings = fileRepository.getListByFile(fileName);
        String stringFromFile = getStringFromArray(strings);

        if (stringForTaskValidator.isValidArguments(stringFromFile)) {
            String numberSeparator = SeparatorSelector.getSeparatorOfNumbers(stringFromFile);
            String[] numbersInString = stringFromFile.split(numberSeparator);

            List<String> listStringsForValidString = Arrays.stream(numbersInString)
                    .limit(LimitNumber.LIMIT_NUMBERS_IN_VALID_STRING)
                    .collect(Collectors.toList());

            return getStringFromArray(listStringsForValidString);
        } else {
            throw new IllegalArgumentException("the file contains two different delimiters, you must select only one");
        }
    }


    private String getStringFromArray(List<String> strings) {
        String[] arrayStrings = strings.toArray(new String[0]);
        return Arrays.stream(arrayStrings).collect(Collectors.joining(","));
    }


}
