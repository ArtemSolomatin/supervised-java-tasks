package JpaApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import JpaApplication.entity.Role;
import JpaApplication.entity.User;
import JpaApplication.repository.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Artem Solomatin on 20.08.17.
 * AcademicProgress
 *
 * Для того, чтобы связать сервис UserService со Spring Security, нужно реализовать специальный интерфейс фреймворка Spring Security который позволит выполнять аутентификацию пользователя на основании данных полученых с UserService
 *Авторизация осуществляется через XML-файл конфигурации appconfig-security.xml
 *
 * To implement login/authentication with Spring Security, we need to implement org.springframework.security.core.userdetails.UserDetailsService interface
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
