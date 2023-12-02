package exercise.mapper;

import exercise.dto.UserCreateDTO;
import exercise.dto.UserDTO;
import exercise.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T16:26:08+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User map(UserCreateDTO dto) {
        encryptPassword( dto );

        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( dto.getEmail() );
        user.setName( dto.getName() );
        user.setPasswordDigest( dto.getPasswordDigest() );

        return user;
    }

    @Override
    public UserDTO map(User model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCreatedAt( model.getCreatedAt() );
        userDTO.setEmail( model.getEmail() );
        userDTO.setId( model.getId() );
        userDTO.setName( model.getName() );

        return userDTO;
    }
}
