package com.pawmade.living.dto.model;

import com.pawmade.living.constante.Breed;
import com.pawmade.living.constante.Sex;
import com.pawmade.living.constante.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Dog(
        Long id,
        String name,
        Breed breed,
        LocalDate birthDate,
        Sex sex,
        BigDecimal weight,
        String photoUrl,
        Type type
) implements Living {
}
