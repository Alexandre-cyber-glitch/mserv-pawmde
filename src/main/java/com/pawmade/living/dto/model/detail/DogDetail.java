package com.pawmade.living.dto.model.detail;

import com.pawmade.living.constante.Breed;
import com.pawmade.living.constante.Sex;
import com.pawmade.living.constante.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DogDetail(
        Long id, String name,
        String photoUrl,
        Type type,
        LocalDate birthDate,
        Sex sex,
        BigDecimal weight,
        Breed breed
) implements LivingDetail {
}
