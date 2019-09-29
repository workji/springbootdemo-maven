package com.ki.repository;

import com.ki.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from user where email = ?1 and password = ?2", nativeQuery = true)
    UserEntity findByUserEmailAndPassword(String userName, String Password);
}
