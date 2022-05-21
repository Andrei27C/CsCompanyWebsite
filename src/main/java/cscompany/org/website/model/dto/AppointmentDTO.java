package cscompany.org.website.model.dto;

import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.UserEntity;
import lombok.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AppointmentDTO {
    @NonNull
    private Date startDate;
    @NonNull
    private EmployeeDTO employeeDTO;
    @NonNull
    private UserDTO userDTO;
}
