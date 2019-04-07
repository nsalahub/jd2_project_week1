package com.gmail.salahub.nikolay.web.app;

import com.gmail.salahub.nikolay.service.FileService;
import com.gmail.salahub.nikolay.service.StringActionService;
import com.gmail.salahub.nikolay.service.impl.FileServiceImpl;
import com.gmail.salahub.nikolay.service.impl.StringActionServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = (Logger) LogManager.getLogger(App.class);

    public static void main(String[] args) {

        FileService fileService = FileServiceImpl.getInstance();
        StringActionService stringActionService = StringActionServiceImpl.getInstance();
        try {
            String validString = fileService.getValidStringFromFile("test.txt");
            int sumResult = stringActionService.add(validString);
            System.out.println(sumResult);
            logger.info(sumResult);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }

    }
}
