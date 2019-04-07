package com.gmail.salahub.nikolay;

import com.gmail.salahub.nikolay.repository.FileRepository;
import com.gmail.salahub.nikolay.repository.impl.FileRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class FileRepositoryTest {

    private FileRepository fileRepository = FileRepositoryImpl.getInstance();

    @Test
    public void shouldVoidReturnNoEmptyArray() throws IOException {
        String testString = "1,12,23,2342234234,234234,22";
        byte[] buffer = testString.getBytes();
        try (OutputStream outputStream = new FileOutputStream(new File("testdata.txt"))) {
            outputStream.write(buffer);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        List<String> returnedList = fileRepository.getListByFile("testdata.txt");
        Assert.assertEquals("1,12,23,2342234234,234234,22", returnedList.get(0));
    }

}