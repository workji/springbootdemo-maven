package com.ki.repository;

import com.ki.entity.MultiEntity;
import com.ki.entity.MultiKeysClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiRepository extends JpaRepository<MultiEntity, MultiKeysClass> {
}
