package cscompany.org.website.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "employee", schema = "sd_project")
public class EmployeeEntity extends UserData {
//    @Id
//    @Column(name = "id_employee")
//    @GeneratedValue
//    private int idEmployee;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user_data")
//    private UserData idUserData;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private DepartmentEntity departmentEntity;

    @Builder(builderMethodName = "EmployeeBuilder")
    public EmployeeEntity(int idUserData, String name, String phone, String username, String password, String email, int idEmployee, UserData idUserData1, DepartmentEntity departmentEntity) {
        super(idUserData, name, phone, username, password, email);
        this.departmentEntity = departmentEntity;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EmployeeEntity that = (EmployeeEntity) o;
//        return idEmployee == that.idEmployee;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(idEmployee);
//    }
}
