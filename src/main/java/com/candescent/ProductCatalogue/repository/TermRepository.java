package com.candescent.ProductCatalogue.repository;

import com.candescent.ProductCatalogue.entities.TermEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Repository for Term database operations.
 */
@Repository
public interface TermRepository extends JpaRepository<TermEntity, Long> {

    /** Finds term by code. */
    Optional<TermEntity> findByCode(String code);
}

