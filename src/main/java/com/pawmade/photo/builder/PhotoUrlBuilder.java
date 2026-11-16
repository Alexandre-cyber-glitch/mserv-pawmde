package com.pawmade.photo.builder;

import com.pawmade.photo.entity.PhotoEntity;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class PhotoUrlBuilder {

    @Named("photoUrl")
    public String url(PhotoEntity photo) {
        return photo == null ? null : "/api/photos/" + photo.getId() + "/content";
    }
}
