package com.pawmade.living.entity;

import com.pawmade.living.constante.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "plant")
@Getter
@Setter
@NoArgsConstructor
public class PlantEntity extends LivingEntity {

    @Enumerated(EnumType.STRING)
    private Type type;

    private String species;

    private LocalDate acquisitionDate;

    private Integer wateringFrequencyDays;
}
