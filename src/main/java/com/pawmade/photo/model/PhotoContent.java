package com.pawmade.photo.model;

import org.springframework.core.io.Resource;

public record PhotoContent(Resource resource, String contentType) {
}