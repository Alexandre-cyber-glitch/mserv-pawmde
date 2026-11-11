package com.pawmade.dog.service;

import com.pawmade.dog.dto.mapper.DogMapper;
import com.pawmade.dog.dto.request.DogCreateRequest;
import com.pawmade.dog.dto.request.DogUpdateRequest;
import com.pawmade.dog.dto.response.DogResponse;
import com.pawmade.dog.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DogService {

    private final DogRepository dogRepository;
    private final DogMapper dogMapper;

    public DogResponse create(DogCreateRequest request) {
        var dog = dogMapper.toEntity(request);
        dog = dogRepository.save(dog);
        return dogMapper.toResponse(dog);
    }

    @Transactional
    public DogResponse update(Long id, DogUpdateRequest request) {
        var dogEntityOptional = dogRepository.findById(id);
        if (dogEntityOptional.isEmpty()) {
            throw new IllegalStateException("Dog not found with id: " + id);
        }

        var dog = dogEntityOptional.get();
        dogMapper.update(request, dog);
        var savedDog = dogRepository.save(dog);
        return dogMapper.toResponse(savedDog);
    }
}
