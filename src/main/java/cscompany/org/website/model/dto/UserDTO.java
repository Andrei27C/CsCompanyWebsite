package cscompany.org.website.model.dto;

import cscompany.org.website.model.UserData;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@ToString(callSuper=true)
public class UserDTO extends UserDataDTO{

    @Builder(builderMethodName = "UserDTOBuilder")
    public UserDTO(@NonNull String name, @NonNull String phone, @NonNull String username, @NonNull String password, @NonNull String email) {
        super(name, phone, username, password, email);
    }
}
