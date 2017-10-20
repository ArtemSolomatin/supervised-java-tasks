package Graph.entities;

import lombok.*;

/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Node {
    /**
     * water is wet
     *
     * @param new age of the person
     * @return current value of age
     */
    @Getter private final char name;
    @Getter @Setter private boolean inTree;
    @Getter private int cost;
}
