package com.pawmade.living.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = UpdateDogRequest.class, name = "DOG"),
        @JsonSubTypes.Type(value = UpdatePlantRequest.class, name = "PLANT")
})
public sealed interface UpdateLivingRequest permits UpdateDogRequest, UpdatePlantRequest {
}
