package cscompany.org.website.repository;

import cscompany.org.website.model.DepartmentEntity;
import cscompany.org.website.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
    List<DepartmentEntity> findAll();

}
