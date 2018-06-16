package JpaApplication.security;

/**
 * Created by Artem Solomatin on 25.10.17.
 * AcademicProgress
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
