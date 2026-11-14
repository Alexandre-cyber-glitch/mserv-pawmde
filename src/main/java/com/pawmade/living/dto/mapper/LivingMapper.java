package com.pawmade.living.dto.mapper;

import com.pawmade.living.dto.model.detail.DogDetail;
import com.pawmade.living.dto.model.detail.LivingDetail;
import com.pawmade.living.dto.model.detail.PlantDetail;
import com.pawmade.living.dto.model.summary.LivingSummary;
import com.pawmade.living.entity.DogEntity;
import com.pawmade.living.entity.LivingEntity;
import com.pawmade.living.entity.PlantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION
)
public interface LivingMapper {

    LivingSummary toSummary(LivingEntity entity);

    List<LivingSummary> toSummaries(List<LivingEntity> entities);

    @SubclassMapping(source = DogEntity.class, target = DogDetail.class)
    @SubclassMapping(source = PlantEntity.class, target = PlantDetail.class)
    LivingDetail toDetail(LivingEntity entity);

    DogDetail toDetail(DogEntity entity);

    PlantDetail toDetail(PlantEntity entity);
}