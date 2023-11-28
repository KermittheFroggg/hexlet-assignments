package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Category;
import exercise.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-28T20:54:47+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl extends ProductMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public Product map(ProductCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setPrice( dto.getPrice() );
        product.setTitle( dto.getTitle() );

        return product;
    }

    @Override
    public void update(ProductUpdateDTO dto, Product product) {
        if ( dto == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( dto.getPrice() ) ) {
            product.setPrice( jsonNullableMapper.unwrap( dto.getPrice() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getTitle() ) ) {
            product.setTitle( jsonNullableMapper.unwrap( dto.getTitle() ) );
        }
    }

    @Override
    public ProductDTO map(Product model) {
        if ( model == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategoryId( modelCategoryId( model ) );
        productDTO.setCreatedAt( model.getCreatedAt() );
        productDTO.setId( model.getId() );
        productDTO.setPrice( model.getPrice() );
        productDTO.setTitle( model.getTitle() );
        productDTO.setUpdatedAt( model.getUpdatedAt() );

        return productDTO;
    }

    private Long modelCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        long id = category.getId();
        return id;
    }
}
