package cscompany.org.website.model.mapper;

import cscompany.org.website.model.UserEntity;
import cscompany.org.website.model.dto.UserDTO;

public class UserMapper implements Mapper<UserEntity, UserDTO> {
    private static UserMapper userMapper = null;

    private UserMapper() { }

    public static UserMapper getInstance() {
        if (userMapper == null) {
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    @Override
    public UserEntity convertFromDTO(UserDTO userDTO) {
        return UserEntity.UserEntityBuilder()
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .phone(userDTO.getPhone())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

    }

    @Override
    public UserDTO convertToDTO(UserEntity userEntity) {
        return UserDTO.UserDTOBuilder()
                .name(userEntity.getName())
                .phone(userEntity.getPhone())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .build();//.idUserData(userEntity.getIdUserData())
    }
}
