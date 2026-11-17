package com.pawmade.photo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PhotoResponse(
        UUID id,
        String url,
        String contentType,
        Long sizeBytes,
        Integer width,
        Integer height,
        LocalDateTime createdAt
) {
}
