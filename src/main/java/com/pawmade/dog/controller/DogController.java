package com.pawmade.dog.controller;

import com.pawmade.dog.dto.request.DogCreateRequest;
import com.pawmade.dog.dto.request.DogUpdateRequest;
import com.pawmade.dog.dto.response.DogResponse;
import com.pawmade.dog.service.DogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    @PostMapping
    public ResponseEntity<DogResponse> create(@Valid @RequestBody DogCreateRequest request) {
        var response = dogService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DogResponse> update(@PathVariable Long id, @Valid @RequestBody DogUpdateRequest request) {
        return ResponseEntity.ok(dogService.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<DogResponse>> findAll() {
        return ResponseEntity.ok((dogService.findAll()));
    }
}
