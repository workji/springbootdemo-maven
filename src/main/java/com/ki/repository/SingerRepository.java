package com.ki.repository;

import com.ki.entity.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<SingerEntity, Long> {
}
