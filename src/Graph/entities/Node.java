package Graph.entities;

/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 */
public class Node {
    private final char name;
    private boolean inTree;
    private int cost;

    public Node(char name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public char getName() {
        return name;
    }

    public boolean isInTree() {
        return inTree;
    }

    public void setInTree(boolean inTree) {
        this.inTree = inTree;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
