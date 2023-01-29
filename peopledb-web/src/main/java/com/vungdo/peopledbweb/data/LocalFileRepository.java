package com.vungdo.peopledbweb.data;

import com.vungdo.peopledbweb.exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class LocalFileRepository {
    @Value("${STORAGE_FOLDER}")
    private String STORAGE_FOLDER;

    public void save(String filename, InputStream inputStream) {
        try {
            System.out.println("STORAGE_FOLDR: " + STORAGE_FOLDER);
            Path filePath = Path.of(STORAGE_FOLDER).resolve(filename).normalize();
            Files.copy(inputStream, filePath);
        } catch (IOException e) {
            throw new StorageException(e);
        }
    }

    public Resource getResource(String fileName) {
        try {
            Path filePath = Path.of(STORAGE_FOLDER).resolve(fileName).normalize();
            return new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new StorageException(e);
        }
    }
}
