package com.pawmade.living.dto.request;

import com.pawmade.living.constant.Breed;
import com.pawmade.living.constant.Sex;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateDogRequest(
        @NotBlank @Size(max = 50) String name,
        @PastOrPresent LocalDate birthDate,
        Sex sex,
        @Positive @Digits(integer = 3, fraction = 2) BigDecimal weight,
        Breed breed
) implements UpdateLivingRequest {
}
