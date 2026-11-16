package com.pawmade.living.entity;

import com.pawmade.living.constant.Type;
import com.pawmade.photo.entity.PhotoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "living")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Getter
@Setter
@NoArgsConstructor
public abstract class LivingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar_photo_id")
    private PhotoEntity avatarPhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cover_photo_id")
    private PhotoEntity coverPhoto;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private Type type;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
