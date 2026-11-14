package com.pawmade.living.repository;

import com.pawmade.living.entity.LivingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivingRepository extends JpaRepository<LivingEntity, Long> {
}