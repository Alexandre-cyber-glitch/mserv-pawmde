package com.pawmade.living.service;

import com.pawmade.living.dto.mapper.LivingMapper;
import com.pawmade.living.dto.request.UpdateDogRequest;
import com.pawmade.living.dto.request.UpdateLivingRequest;
import com.pawmade.living.dto.request.UpdatePlantRequest;
import com.pawmade.living.dto.response.GetLivingDetailResponse;
import com.pawmade.living.dto.response.GetLivingListResponse;
import com.pawmade.living.entity.DogEntity;
import com.pawmade.living.entity.LivingEntity;
import com.pawmade.living.entity.PlantEntity;
import com.pawmade.living.exception.LivingNotFoundException;
import com.pawmade.living.exception.LivingTypeMismatchException;
import com.pawmade.living.repository.LivingRepository;
import com.pawmade.photo.entity.PhotoEntity;
import com.pawmade.photo.exception.InvalidPhotoException;
import com.pawmade.photo.exception.PhotoNotFoundException;
import com.pawmade.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivingService {

    private final LivingRepository livingRepository;
    private final LivingMapper livingMapper;
    private final PhotoRepository photoRepository;

    public GetLivingListResponse findAll() {
        var livings = livingRepository.findAll(Sort.by("createdAt"));
        return new GetLivingListResponse(livingMapper.toSummaries(livings));
    }

    public GetLivingDetailResponse findById(Long id) {
        var entity = livingRepository.findById(id).orElseThrow(() -> new LivingNotFoundException(id));
        return new GetLivingDetailResponse(livingMapper.toDetail(entity));
    }

    @Transactional
    public GetLivingDetailResponse update(Long id, UpdateLivingRequest request) {
        var entity = livingRepository.findById(id).orElseThrow(() -> new LivingNotFoundException(id));
        if (request instanceof UpdateDogRequest dogRequest && entity instanceof DogEntity dog) {
            livingMapper.update(dogRequest, dog);
        } else if (request instanceof UpdatePlantRequest plantRequest && entity instanceof PlantEntity plant) {
            livingMapper.update(plantRequest, plant);
        } else {
            throw new LivingTypeMismatchException(id, entity.getType());
        }
        return new GetLivingDetailResponse(livingMapper.toDetail(entity));
    }

    @Transactional
    public GetLivingDetailResponse setAvatar(Long id, UUID photoId) {
        var living = livingRepository.findById(id).orElseThrow(() -> new LivingNotFoundException(id));
        living.setAvatarPhoto(findOwnerPhoto(living, photoId));
        return new GetLivingDetailResponse(livingMapper.toDetail(living));
    }

    @Transactional
    public GetLivingDetailResponse setCover(Long id, UUID photoId) {
        var living = livingRepository.findById(id).orElseThrow(() -> new LivingNotFoundException(id));
        living.setCoverPhoto(findOwnerPhoto(living, photoId));
        return new GetLivingDetailResponse(livingMapper.toDetail(living));
    }

    private PhotoEntity findOwnerPhoto(LivingEntity living, UUID photoId) {
        var photo = photoRepository.findById(photoId).orElseThrow(() -> new PhotoNotFoundException(photoId));
        if (photo.getLiving() == null || !photo.getLiving().getId().equals(living.getId())) {
            throw new InvalidPhotoException("Photo " + photoId + " does not belong to living " + living.getId());
        }
        return photo;
    }
}
