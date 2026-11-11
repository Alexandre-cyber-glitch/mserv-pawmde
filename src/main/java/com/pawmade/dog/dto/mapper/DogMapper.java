package com.pawmade.dog.dto.mapper;

import com.pawmade.dog.dto.request.DogCreateRequest;
import com.pawmade.dog.dto.request.DogUpdateRequest;
import com.pawmade.dog.dto.response.DogResponse;
import com.pawmade.dog.entity.DogEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DogMapper {

    DogEntity toEntity(DogCreateRequest request);

    DogResponse toResponse(DogEntity dog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(DogUpdateRequest request, @MappingTarget DogEntity dog);
}