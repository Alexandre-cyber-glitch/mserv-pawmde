package com.pawmade.living.dto.model.summary;

import com.pawmade.living.constant.Type;

public record LivingSummary(
        Long id,
        String name,
        String avatarUrl,
        Type type
) {
}
