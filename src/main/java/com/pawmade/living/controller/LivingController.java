package com.pawmade.living.controller;


import com.pawmade.living.dto.response.GetLivingListResponse;
import com.pawmade.living.service.LivingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/living")
@RequiredArgsConstructor
public class LivingController {

    private final LivingService livingService;

    @GetMapping
    public ResponseEntity<GetLivingListResponse> findAll() {
        return ResponseEntity.ok((livingService.findAll()));
    }
}
