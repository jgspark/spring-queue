package com.example.messagingrabbitmq.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MockUtil {

    public static <T> T readJons(String path, Class<T> type) {
        try {
            File resource = new ClassPathResource(path).getFile();
            String value = new String(Files.readAllBytes(resource.toPath()));
            ObjectMapper om = new ObjectMapper();
            return om.readValue(value, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
