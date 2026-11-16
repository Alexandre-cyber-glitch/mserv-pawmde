package com.pawmade.photo.service;

import org.springframework.core.io.Resource;

import java.io.InputStream;

public interface StorageService {
    void store(String key, InputStream content);

    Resource load(String key);

    void delete(String key);
}
