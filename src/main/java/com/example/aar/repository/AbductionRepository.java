package com.example.aar.repository;

import com.example.aar.model.Abduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbductionRepository extends JpaRepository<Abduction, Long> {

    @Query("SELECT a FROM Abduction a WHERE a.name LIKE %:query% OR a.place LIKE %:query% OR a.details LIKE %:query%")
    List<Abduction> findByNameContainingOrPlaceContainingOrDetailsContaining(@Param("query") String query);
}
