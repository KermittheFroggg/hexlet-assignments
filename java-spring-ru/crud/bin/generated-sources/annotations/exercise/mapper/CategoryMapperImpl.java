package exercise.mapper;

import exercise.dto.CategoryCreateDTO;
import exercise.dto.CategoryDTO;
import exercise.model.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-28T20:54:47+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl extends CategoryMapper {

    @Override
    public Category map(CategoryCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( dto.getName() );

        return category;
    }

    @Override
    public CategoryDTO map(Category model) {
        if ( model == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCreatedAt( model.getCreatedAt() );
        categoryDTO.setId( model.getId() );
        categoryDTO.setName( model.getName() );

        return categoryDTO;
    }
}
