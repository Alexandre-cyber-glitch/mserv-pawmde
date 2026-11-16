package com.pawmade.photo.service;

import com.pawmade.photo.exception.PhotoNotFoundException;
import com.pawmade.photo.model.PhotoContent;
import com.pawmade.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final StorageService storageService;

    @Transactional(readOnly = true)
    public PhotoContent loadContent(UUID id) {
        var photo = photoRepository.findById(id).orElseThrow(() -> new PhotoNotFoundException(id));
        var resource = storageService.load(photo.getStorageKey());
        var contentType = photo.getContentType();
        return new PhotoContent(resource, contentType);
    }
}
