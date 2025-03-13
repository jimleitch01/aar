package com.example.aar.repository;

import com.example.aar.model.Abduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbductionRepository extends JpaRepository<Abduction, Long> {
}
