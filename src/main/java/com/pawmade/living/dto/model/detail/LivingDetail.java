package com.pawmade.living.dto.model.detail;

import com.pawmade.living.constante.Type;

public sealed interface LivingDetail permits DogDetail, PlantDetail {
    Long id();
    String name();
    String photoUrl();
    Type type();
}
