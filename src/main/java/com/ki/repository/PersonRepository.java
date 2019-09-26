package com.ki.repository;

import com.ki.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(value = "select p.name, s.classname from person p, student s where p.id = s.pid and p.name like ?1%", nativeQuery = true)
    List<Object[]> findAllByParameter(String personName);

    @Query(value = "select p.name, s.classname from person p, student s where p.id = s.pid",
            countQuery = "select count(*) from (select p.name, s.classname from person p, student s where p.id = s.pid) m",
            nativeQuery = true)
    Page<Object[]> findAllByNo(Pageable pageable);

}
