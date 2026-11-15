package com.pawmade.living.entity;

import com.pawmade.living.constant.Breed;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dog")
@DiscriminatorValue("DOG")
@Getter
@Setter
@NoArgsConstructor
public class DogEntity extends AnimalEntity {

    @Enumerated(EnumType.STRING)
    private Breed breed;
}
