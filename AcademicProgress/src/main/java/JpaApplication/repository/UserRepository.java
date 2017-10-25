package JpaApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import JpaApplication.entity.User;

/**
 * Created by Artem Solomatin on 24.10.17.
 * AcademicProgress
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
