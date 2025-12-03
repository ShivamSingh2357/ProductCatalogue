package com.candescent.ProductCatalogue.repository;

import com.candescent.ProductCatalogue.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Feature database operations.
 */
@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {

    /** Finds feature by code. */
    Optional<FeatureEntity> findByCode(String code);
}

