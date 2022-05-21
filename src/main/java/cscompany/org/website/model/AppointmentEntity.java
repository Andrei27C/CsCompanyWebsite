package cscompany.org.website.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointment", schema = "sd_project")
public class AppointmentEntity {
    @Id
    @Column(name = "id_appointment")
    @GeneratedValue
    private int idAppointment;

    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employeeEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return idAppointment == that.idAppointment &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAppointment, startDate);
    }
}
