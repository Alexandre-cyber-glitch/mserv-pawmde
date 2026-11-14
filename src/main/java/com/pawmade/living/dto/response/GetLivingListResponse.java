package com.pawmade.living.dto.response;

import com.pawmade.living.dto.model.summary.LivingSummary;

import java.util.List;

public record GetLivingListResponse(
        List<LivingSummary> livings
) {
}
