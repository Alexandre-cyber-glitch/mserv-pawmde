package com.pawmade.living.service;

import com.pawmade.living.dto.mapper.LivingMapper;
import com.pawmade.living.dto.response.GetLivingDetailResponse;
import com.pawmade.living.dto.response.GetLivingListResponse;
import com.pawmade.living.exception.LivingNotFoundException;
import com.pawmade.living.repository.LivingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivingService {

    private final LivingRepository livingRepository;
    private final LivingMapper livingMapper;

    public GetLivingListResponse findAll() {
        var livings = livingRepository.findAll(Sort.by("createdAt"));
        return new GetLivingListResponse(livingMapper.toSummaries(livings));
    }

    public GetLivingDetailResponse findById(Long id) {
        var entity = livingRepository.findById(id).orElseThrow(() -> new LivingNotFoundException(id));
        return new GetLivingDetailResponse(livingMapper.toDetail(entity));
    }
}
