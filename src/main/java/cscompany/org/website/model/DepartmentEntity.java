package cscompany.org.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "department", schema = "sd_project")
public class DepartmentEntity {
    @Id
    @Column(name = "id_department")
    @GeneratedValue
    private int idDepartment;

    @Basic
    @Column(name = "department_name")
    private String departmentName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return idDepartment == that.idDepartment &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, departmentName);
    }
}
