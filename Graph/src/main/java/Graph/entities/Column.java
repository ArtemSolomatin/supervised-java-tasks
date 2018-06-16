package Graph.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 *
 * Столбец таблицы кратчайших путей, хранящий расстояние и родительскую вершину.
 */
// TODO: 7/9/2017 lombok this shit

public class Column {
    @Getter @Setter private int distance;
    @Getter @Setter private int parent;

    public Column(int parent, int distance) {
        this.parent = parent;
        this.distance = distance;
    }
}
