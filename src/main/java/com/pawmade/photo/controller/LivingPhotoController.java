package com.pawmade.photo.controller;

import com.pawmade.living.dto.response.GetLivingDetailResponse;
import com.pawmade.living.service.LivingService;
import com.pawmade.photo.dto.PhotoResponse;
import com.pawmade.photo.dto.SetPhotoRequest;
import com.pawmade.photo.service.PhotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping("/api/living/{livingId}")
@RequiredArgsConstructor
public class LivingPhotoController {

    private final LivingService livingService;
    private final PhotoService photoService;

    @PostMapping(path = "/photos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PhotoResponse> upload(@PathVariable Long livingId, @RequestParam("file") MultipartFile file) {
        var photo = photoService.upload(livingId, file);
        return ResponseEntity.created(URI.create(photo.url())).body(photo);
    }

    @PutMapping("/avatar")
    public ResponseEntity<GetLivingDetailResponse> setAvatar(@PathVariable Long livingId, @Valid @RequestBody SetPhotoRequest request) {
        return ResponseEntity.ok(livingService.setAvatar(livingId, request.photoId()));
    }

    @PutMapping("/cover")
    public ResponseEntity<GetLivingDetailResponse> setCover(@PathVariable Long livingId, @Valid @RequestBody SetPhotoRequest request) {
        return ResponseEntity.ok(livingService.setCover(livingId, request.photoId()));
    }

}
