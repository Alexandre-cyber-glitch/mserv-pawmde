package com.pawmade.dog.dto.response;

import com.pawmade.dog.constante.Breed;
import com.pawmade.dog.constante.Sex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DogResponse(
        Long id,
        String name,
        Breed breed,
        LocalDate birthDate,
        Sex sex,
        BigDecimal weight,
        String photoUrl,
        LocalDateTime createdAt
) {
}
