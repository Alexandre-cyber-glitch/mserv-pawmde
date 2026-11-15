package com.pawmade.living.dto.model.detail;

import com.pawmade.living.constant.Type;

import java.time.LocalDate;

public record PlantDetail(
        Long id,
        String name,
        String avatarUrl,
        String coverUrl,
        Type type,
        String species,
        LocalDate acquisitionDate,
        Integer wateringFrequencyDays
) implements LivingDetail {
}
