package cscompany.org.website.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDataDTO {
    @NonNull
    private String name;
    @NonNull
    private String phone;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
}
