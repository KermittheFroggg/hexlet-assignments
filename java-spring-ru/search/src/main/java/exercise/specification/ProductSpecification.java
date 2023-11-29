package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withTitleCont(params.getTitleCont())
                .and(withPriceLt(params.getPriceLt()))
                .and(withCategoryId(params.getCategoryId()))
                .and(withPriceGt(params.getPriceGt()))
                .and(withRatingGt(params.getRatingGt()));
    }

    private Specification<Product> withTitleCont(String titleCont) {
        return (root, query, builder) -> {
            if (titleCont == null) {
                return null;
            }
            return builder.like(root.get("title"), "%" + titleCont + "%");
        };
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, builder) -> {
            if (priceLt == null) {
                return null;
            }
            return builder.lessThan(root.get("price"), priceLt);
        };
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, builder) -> {
            if (categoryId == null) {
                return null;
            }
            return builder.equal(root.get("category").get("id"), categoryId);
        };
    }

    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, builder) -> {
            if (priceGt == null) {
                return null;
            }
            return builder.greaterThan(root.get("price"), priceGt);
        };
    }

    private Specification<Product> withRatingGt(Double ratingGt) {
        return (root, query, builder) -> {
            if (ratingGt == null) {
                return null;
            }
            return builder.greaterThan(root.get("rating"), ratingGt);
        };
    }

// END
}