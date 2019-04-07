package com.gmail.salahub.nikolay;

import com.gmail.salahub.nikolay.service.FileService;
import com.gmail.salahub.nikolay.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class FileServiceTest {

    private FileService fileService = FileServiceImpl.getInstance();

    @Test(expected = IllegalArgumentException.class)
    public void shodVoidThrowException() throws IOException {
        String invalidNumberString = "1:2,3";
        String result = fileService.getValidStringFromFile(invalidNumberString);
    }

    @Test
    public void shouldIsReturnedValidString() throws IOException {
        String testString = "1,12,23,2342234234,234234,22";
        byte[]buffer = testString.getBytes();
        try (OutputStream outputStream = new FileOutputStream(new File("testdata.txt"))) {
            outputStream.write(buffer);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        String resultString = fileService.getValidStringFromFile("testdata.txt");
        Assert.assertEquals("1,12",resultString);
    }


}
