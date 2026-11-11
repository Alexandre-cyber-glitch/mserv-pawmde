package com.pawmade.dog.dto.request;

import com.pawmade.dog.constante.Breed;
import com.pawmade.dog.constante.Sex;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DogCreateRequest(
        String name,
        Breed breed,
        LocalDate birthDate,
        Sex sex,
        BigDecimal weight,
        String photoUrl
) {
}
