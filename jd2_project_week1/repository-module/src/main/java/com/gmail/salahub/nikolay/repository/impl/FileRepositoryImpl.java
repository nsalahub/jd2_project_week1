package com.gmail.salahub.nikolay.repository.impl;

import com.gmail.salahub.nikolay.repository.FileRepository;
import com.sun.jnlp.FileOpenServiceImpl;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRepositoryImpl implements FileRepository {

    private static FileRepositoryImpl instance;

    private FileRepositoryImpl() {
    }

    public static FileRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new FileRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<String> getListByFile(String fileName) throws IOException {
        List<String> strings;
        Path path = Paths.get(fileName);
        try (Stream<String> lineStream = Files.lines(path)) {
            strings = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new IOException();
        }
        return strings;
    }
}
