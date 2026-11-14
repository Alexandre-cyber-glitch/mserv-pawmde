package com.pawmade.living.dto.model.detail;

import com.pawmade.living.constante.Type;

import java.time.LocalDate;

public record PlantDetail(
        Long id,
        String name,
        String photoUrl,
        Type type,
        String species,
        LocalDate acquisitionDate,
        Integer wateringFrequencyDays
) implements LivingDetail {
}
