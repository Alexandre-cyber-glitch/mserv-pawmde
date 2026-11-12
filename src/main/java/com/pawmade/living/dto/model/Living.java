package com.pawmade.living.dto.model;

import com.pawmade.living.constante.Type;

public interface Living {
    Long id();

    String name();

    String photoUrl();

    Type type();
}
