package exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;

import exercise.model.BaseEntity;
import jakarta.persistence.EntityManager;

// BEGIN
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {BaseEntity.class}
)
public abstract class ReferenceMapper {
    @Autowired
    private EntityManager entityManager;

    public <T extends BaseEntity> T map(Long id, @TargetType Class<T> type) {
        return id != null ? entityManager.getReference(type, id) : null;
    }

}
// END
