package com.ki.repository;

import com.ki.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepo extends JpaRepository<Alert, Integer> {

}
