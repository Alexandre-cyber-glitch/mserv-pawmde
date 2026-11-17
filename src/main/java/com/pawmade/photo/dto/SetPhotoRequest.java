package com.pawmade.photo.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SetPhotoRequest(@NotNull UUID photoId) {
}
