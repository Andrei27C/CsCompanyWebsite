package cscompany.org.website.model.dto;

import cscompany.org.website.model.DepartmentEntity;
import cscompany.org.website.model.UserData;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class EmployeeDTO extends UserDataDTO{
    private DepartmentEntity departmentEntity;

    @Builder(builderMethodName = "EmployeeDTOBuilder")
    public EmployeeDTO(@NonNull String name, @NonNull String phone, @NonNull String username, @NonNull String password, @NonNull String email, DepartmentEntity departmentEntity) {
        super(name, phone, username, password, email);
        this.departmentEntity = departmentEntity;
    }
}
