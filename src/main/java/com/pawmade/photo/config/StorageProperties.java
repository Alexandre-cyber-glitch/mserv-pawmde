package com.pawmade.photo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties(prefix = "pawmade.storage")
public record StorageProperties(Path root) {
}
