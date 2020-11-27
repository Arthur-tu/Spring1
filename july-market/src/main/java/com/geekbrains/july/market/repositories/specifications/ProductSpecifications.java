package com.geekbrains.july.market.repositories.specifications;

import com.geekbrains.july.market.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> containsString(String subString) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), '%' + subString.toLowerCase() + '%');
    }

    public static Specification<Product> categoryIdIsEqualTo(Long id) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category"), id);
    }
}
