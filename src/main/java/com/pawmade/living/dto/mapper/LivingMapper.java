package com.pawmade.living.dto.mapper;

import com.pawmade.living.dto.model.detail.DogDetail;
import com.pawmade.living.dto.model.detail.LivingDetail;
import com.pawmade.living.dto.model.detail.PlantDetail;
import com.pawmade.living.dto.model.summary.LivingSummary;
import com.pawmade.living.dto.request.UpdateDogRequest;
import com.pawmade.living.dto.request.UpdatePlantRequest;
import com.pawmade.living.entity.DogEntity;
import com.pawmade.living.entity.LivingEntity;
import com.pawmade.living.entity.PlantEntity;
import com.pawmade.photo.builder.PhotoUrlBuilder;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = PhotoUrlBuilder.class,
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION
)
public interface LivingMapper {

    @Mapping(target = "avatarUrl", source = "avatarPhoto", qualifiedByName = "photoUrl")
    LivingSummary toSummary(LivingEntity entity);

    List<LivingSummary> toSummaries(List<LivingEntity> entities);

    @SubclassMapping(source = DogEntity.class, target = DogDetail.class)
    @SubclassMapping(source = PlantEntity.class, target = PlantDetail.class)
    LivingDetail toDetail(LivingEntity entity);

    @Mapping(target = "avatarUrl", source = "avatarPhoto", qualifiedByName = "photoUrl")
    @Mapping(target = "coverUrl",  source = "coverPhoto",  qualifiedByName = "photoUrl")
    DogDetail toDetail(DogEntity entity);

    @Mapping(target = "avatarUrl", source = "avatarPhoto", qualifiedByName = "photoUrl")
    @Mapping(target = "coverUrl", source = "coverPhoto", qualifiedByName = "photoUrl")
    PlantDetail toDetail(PlantEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "avatarPhoto", ignore = true)
    @Mapping(target = "coverPhoto", ignore = true)
    void update(UpdateDogRequest request, @MappingTarget DogEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "avatarPhoto", ignore = true)
    @Mapping(target = "coverPhoto", ignore = true)
    void update(UpdatePlantRequest request, @MappingTarget PlantEntity entity);
}