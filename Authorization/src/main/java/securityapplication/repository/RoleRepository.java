package securityapplication.repository;

import securityapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artem Solomatin on 23.08.17.
 * Authorization
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
}
