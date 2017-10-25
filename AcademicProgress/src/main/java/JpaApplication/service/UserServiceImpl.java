package JpaApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import JpaApplication.entity.Role;
import JpaApplication.entity.User;
import JpaApplication.repository.RoleRepository;
import JpaApplication.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Artem Solomatin on 25.10.17.
 * AcademicProgress
 *
 * Предоставляет услуги по регистрации учетной записи
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Выставляет юзеру роли, шифрует пароль и вызывает метод из спринга для сохранения в бд
	 */
	@Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findOne(1L));   //по умолчанию role = user
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
