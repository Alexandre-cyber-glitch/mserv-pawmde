package com.pawmade.living.service;

import com.pawmade.dog.repository.DogRepository;
import com.pawmade.living.dto.mapper.LivingMapper;
import com.pawmade.living.dto.model.Living;
import com.pawmade.living.dto.response.GetLivingListResponse;
import com.pawmade.plant.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LivingService {

    private final DogRepository dogRepository;
    private final PlantRepository plantRepository;
    private final LivingMapper livingMapper;

    public GetLivingListResponse findAll() {
        var dogs = dogRepository.findAll().stream().map(entity -> (Living) livingMapper.toDto(entity)).toList();
        var plants = plantRepository.findAll().stream().map(entity -> (Living) livingMapper.toDto(entity)).toList();
        var livings = Stream.concat(dogs.stream(), plants.stream()).toList();
        return new GetLivingListResponse(livings);
    }
}
