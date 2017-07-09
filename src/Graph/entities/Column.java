package Graph.entities;

/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 *
 * Столбец таблицы кратчайших путей, хранящий расстояние и родительскую вершину.
 */
// TODO: 7/9/2017 lombok this shit
public class Column {
    private int distance;
    private int parent;

    public Column(int parent, int distance) {
        this.parent = parent;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
