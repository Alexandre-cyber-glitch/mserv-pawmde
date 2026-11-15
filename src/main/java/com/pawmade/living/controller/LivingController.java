package com.pawmade.living.controller;


import com.pawmade.living.dto.request.UpdateLivingRequest;
import com.pawmade.living.dto.response.GetLivingDetailResponse;
import com.pawmade.living.dto.response.GetLivingListResponse;
import com.pawmade.living.service.LivingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/living")
@RequiredArgsConstructor
public class LivingController {

    private final LivingService livingService;

    @GetMapping
    public ResponseEntity<GetLivingListResponse> findAll() {
        return ResponseEntity.ok((livingService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetLivingDetailResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(livingService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetLivingDetailResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateLivingRequest request) {
        return ResponseEntity.ok(livingService.update(id, request));
    }
}
