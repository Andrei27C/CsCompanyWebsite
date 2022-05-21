package cscompany.org.website.repository;

import cscompany.org.website.model.AppointmentEntity;
import cscompany.org.website.model.AppointmentForEmployee;
import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    public List<AppointmentEntity> findAllByEmployeeEntity(EmployeeEntity employeeEntity);
}
