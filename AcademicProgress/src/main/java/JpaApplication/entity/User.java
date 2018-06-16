package JpaApplication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artem Solomatin on 24.10.17.
 * AcademicProgress
 */

@ToString(exclude = "roles")
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;

    @Column(name = "username")
	@Getter @Setter private String username;

    @Column(name = "password")
	@Getter @Setter private String password;

    @Transient
	@Getter @Setter private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
	@Getter @Setter private Set<Role> roles;
}
