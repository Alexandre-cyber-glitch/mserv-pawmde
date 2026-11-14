package com.pawmade.living.entity;

import com.pawmade.living.constante.Breed;
import com.pawmade.living.constante.Sex;
import com.pawmade.living.constante.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dog")
@Getter
@Setter
@NoArgsConstructor
public class DogEntity extends LivingEntity {

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private BigDecimal weight;

    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Enumerated(EnumType.STRING)
    private Type type;
}
