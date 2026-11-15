package com.pawmade.living.dto.model.detail;

import com.pawmade.living.constant.Breed;
import com.pawmade.living.constant.Sex;
import com.pawmade.living.constant.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DogDetail(
        Long id, String name,
        String coverUrl,
        String avatarUrl,
        Type type,
        LocalDate birthDate,
        Sex sex,
        BigDecimal weight,
        Breed breed
) implements LivingDetail {
}
