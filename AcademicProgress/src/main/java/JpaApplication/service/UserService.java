package JpaApplication.service;


import JpaApplication.entity.User;

/**
 * Created by Artem Solomatin on 25.10.17.
 * AcademicProgress
 */

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
