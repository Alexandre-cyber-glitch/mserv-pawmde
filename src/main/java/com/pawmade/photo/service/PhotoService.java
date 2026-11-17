package com.pawmade.photo.service;

import com.pawmade.living.exception.LivingNotFoundException;
import com.pawmade.living.repository.LivingRepository;
import com.pawmade.photo.builder.PhotoUrlBuilder;
import com.pawmade.photo.dto.PhotoResponse;
import com.pawmade.photo.entity.PhotoEntity;
import com.pawmade.photo.exception.InvalidPhotoException;
import com.pawmade.photo.exception.PhotoNotFoundException;
import com.pawmade.photo.model.PhotoContent;
import com.pawmade.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static com.pawmade.photo.model.utils.detectType;
import static com.pawmade.photo.model.utils.readDimensions;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final StorageService storageService;
    private final LivingRepository livingRepository;
    private final PhotoUrlBuilder photoUrlBuilder;

    @Transactional(readOnly = true)
    public PhotoContent loadContent(UUID id) {
        var photo = photoRepository.findById(id).orElseThrow(() -> new PhotoNotFoundException(id));
        var resource = storageService.load(photo.getStorageKey());
        var contentType = photo.getContentType();
        return new PhotoContent(resource, contentType);
    }

    public PhotoResponse upload(Long livingId, MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new InvalidPhotoException("File is empty");
        }
        var living = livingRepository.findById(livingId).orElseThrow(() -> new LivingNotFoundException(livingId));

        var type = detectType(file);
        var key = "photo/" + UUID.randomUUID() + "/original." + type.extension();
        var dimension = readDimensions(file);

        try {
            var photo = new PhotoEntity();
            photo.setLiving(living);
            photo.setStorageKey(key);
            photo.setContentType(type.contentType());
            photo.setSizeBytes(file.getSize());

            if (dimension != null) {
                photo.setWidth(dimension[0]);
                photo.setHeight(dimension[1]);
            }
            photo = photoRepository.saveAndFlush(photo);
            return toResponse(photo);
        } catch (RuntimeException e) {
            storageService.delete(key);
            throw (e);
        }
    }

    private PhotoResponse toResponse(PhotoEntity p) {
        return new PhotoResponse(p.getId(), photoUrlBuilder.url(p), p.getContentType(),
                p.getSizeBytes(), p.getWidth(), p.getHeight(), p.getCreatedAt());
    }
}
