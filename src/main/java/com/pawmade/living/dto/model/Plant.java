package com.pawmade.living.dto.model;

import com.pawmade.living.constante.Type;

import java.time.LocalDate;

public record Plant(
        Long id,
        String name,
        LocalDate acquisitionDate,
        String species,
        Integer wateringFrequencyDays,
        String photoUrl,
        Type type
) implements Living {
}

