package com.pawmade.photo.entity;

import com.pawmade.living.entity.LivingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "photo", indexes = {
        @Index(columnList = "living_id, taken_at"),
        @Index(columnList = "taken_at")
})
@Getter
@Setter
@NoArgsConstructor
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "living_id")
    private LivingEntity living;

    @Column(nullable = false, unique = true)
    private String storageKey;

    private String contentType;
    private Long sizeBytes;
    private Integer width;
    private Integer height;
    private LocalDateTime takenAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}
