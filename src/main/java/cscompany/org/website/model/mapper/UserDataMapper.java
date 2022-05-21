package cscompany.org.website.model.mapper;

import cscompany.org.website.model.UserData;
import cscompany.org.website.model.dto.UserDataDTO;

public class UserDataMapper implements Mapper<UserData, UserDataDTO> {

    private static UserDataMapper userDataMapper = null;

    private UserDataMapper() { }

    public static UserDataMapper getInstance() {
        if (userDataMapper == null) {
            userDataMapper = new UserDataMapper();
        }
        return userDataMapper;
    }

    @Override
    public UserData convertFromDTO(UserDataDTO userDataDTO) {
        return UserData.builder()
                .name(userDataDTO.getName())
                .phone(userDataDTO.getPhone())
                .username(userDataDTO.getUsername())
                .password(userDataDTO.getPassword())
                .email(userDataDTO.getEmail())
                .build();
    }

    @Override
    public UserDataDTO convertToDTO(UserData userData) {
        return UserDataDTO.builder()
                .name(userData.getName())
                .phone(userData.getPhone())
                .username(userData.getUsername())
                .password(userData.getPassword())
                .email(userData.getEmail())
                .build();
    }
}
