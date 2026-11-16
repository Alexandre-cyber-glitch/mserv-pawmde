package com.pawmade.photo.service;

import com.pawmade.photo.config.StorageProperties;
import com.pawmade.photo.exception.PhotoNotFoundException;
import com.pawmade.photo.exception.StorageException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class LocalStorageService implements StorageService {

    private final Path root;

    public LocalStorageService(StorageProperties properties) {
        this.root = properties.root().toAbsolutePath().normalize();
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new StorageException("Cannot create storage root : " + root, e);
        }
    }

    @Override
    public void store(String key, InputStream content) {
        var target = resolve(key);
        try {
            Files.createDirectories(target.getParent());
            Files.copy(content, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("Cannot store : " + key, e);
        }
    }

    @Override
    public Resource load(String key) {
        var target = resolve(key);
        if (!Files.isRegularFile(target)) {
            throw new PhotoNotFoundException("File not found for key " + key);
        }
        return new FileSystemResource(target);

    }

    @Override
    public void delete(String key) {
        try {
            Files.deleteIfExists(resolve(key));
        } catch (IOException e) {
            throw new StorageException("Cannot delete " + key, e);
        }
    }

    private Path resolve(String key) {
        var target = root.resolve(key).normalize();
        if (!target.startsWith(root)) {
            throw new StorageException("Invalid storage key: " + key);
        }
        return target;
    }
}
