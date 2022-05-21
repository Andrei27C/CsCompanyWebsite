package cscompany.org.website.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DepartmentDTO {
    @NonNull
    private String departmentName;
}
