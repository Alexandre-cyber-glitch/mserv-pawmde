package com.pawmade.living.dto.model.summary;

import com.pawmade.living.constante.Type;

public record LivingSummary(
        Long id,
        String name,
        String photoUrl,
        Type type
) {
}
