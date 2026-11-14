package com.pawmade.living.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "plant")
@DiscriminatorValue("PLANT")
@Getter
@Setter
@NoArgsConstructor
public class PlantEntity extends LivingEntity {

    private String species;
    private LocalDate acquisitionDate;
    private Integer wateringFrequencyDays;
}
