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

@ToString(exclude = "users")
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;

    @Column(name = "name")
	@Getter @Setter private String name;

    @ManyToMany(mappedBy = "roles")
	@Getter @Setter private Set<User> users;

    public Role() {
    }
}
