package com.candescent.ProductCatalogue.specification;

import com.candescent.ProductCatalogue.common.constants.AppConstants;
import com.candescent.ProductCatalogue.entities.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * JPA Specifications for dynamic ProductEntity queries.
 */
public final class ProductSpecification {

    private ProductSpecification() {}

    public static Specification<ProductEntity> hasCategory(String category) {

        return (root, query, cb) -> cb.equal(
                cb.lower(root.get(AppConstants.EntityField.CATEGORY)),
                category.toLowerCase()
        );
    }

    public static Specification<ProductEntity> hasType(String type) {

        return (root, query, cb) -> cb.equal(
                cb.lower(root.get(AppConstants.EntityField.TYPE)),
                type.toLowerCase()
        );
    }

    public static Specification<ProductEntity> searchByNameOrDescription(String search) {

        return (root, query, cb) -> {
            String pattern = "%" + search.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get(AppConstants.EntityField.NAME)), pattern),
                    cb.like(cb.lower(root.get(AppConstants.EntityField.DESCRIPTION)), pattern)
            );
        };
    }
}




