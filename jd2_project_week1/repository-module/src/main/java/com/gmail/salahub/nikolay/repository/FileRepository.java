package com.gmail.salahub.nikolay.repository;

import java.io.IOException;
import java.util.List;

public interface FileRepository {

    List<String> getListByFile(String fileName) throws IOException;
}
