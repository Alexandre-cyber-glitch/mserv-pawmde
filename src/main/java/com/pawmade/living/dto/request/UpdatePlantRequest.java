package com.pawmade.living.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdatePlantRequest(
        @NotBlank @Size(max = 50) String name,
        @PastOrPresent LocalDate acquisitionDate,
        @Size(max = 100) String species,
        @Positive @Max(365) Integer wateringFrequencyDays
) implements UpdateLivingRequest {
}
