package cscompany.org.website.repository;

import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    List<UserEntity> findAll();

}
