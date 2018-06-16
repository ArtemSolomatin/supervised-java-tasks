package securityapplication.repository;

import securityapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artem Solomatin on 20.08.17.
 * Authorization
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
