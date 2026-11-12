package com.pawmade.living.dto.response;

import com.pawmade.living.dto.model.Living;

import java.util.List;

public record GetLivingListResponse(
        List<Living> livings
) {
}
