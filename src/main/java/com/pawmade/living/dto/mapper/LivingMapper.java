package com.pawmade.living.dto.mapper;

import com.pawmade.living.dto.model.Dog;
import com.pawmade.living.dto.model.Living;
import com.pawmade.living.dto.model.Plant;
import com.pawmade.living.entity.DogEntity;
import com.pawmade.living.entity.LivingEntity;
import com.pawmade.living.entity.PlantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION
)
public interface LivingMapper {

    @SubclassMapping(source = DogEntity.class, target = Dog.class)
    @SubclassMapping(source = PlantEntity.class, target = Plant.class)
    Living toDto(LivingEntity entity);

    @Mapping(target = "type", constant = "DOG")
    Dog toDto(DogEntity entity);

    @Mapping(target = "type", constant = "PLANT")
    Plant toDto(PlantEntity entity);
}