package JpaApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import JpaApplication.entity.Role;

/**
 * Created by Artem Solomatin on 24.10.17.
 * AcademicProgress
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
}
