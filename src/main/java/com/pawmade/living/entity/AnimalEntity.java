package com.pawmade.living.entity;

import com.pawmade.living.constante.Sex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
public abstract class AnimalEntity extends LivingEntity {

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(precision = 5, scale = 2)
    private BigDecimal weight;
}
