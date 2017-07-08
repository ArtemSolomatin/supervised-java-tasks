package Graph;


/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 */
public class GraphTest {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addNode('A', 0);
        graph.addNode('B', 0);
        graph.addNode('C', 0);
        graph.addNode('D', 0);
        graph.addNode('E', 0);
        graph.addNode('F', 0);
        graph.addNode('E', 0);
        graph.addNode('G', 0);

        graph.addEdge('A', 'B', 30);
        graph.addEdge('A', 'C', 10);
        graph.addEdge('C', 'E', 30);
        graph.addEdge('B', 'E', 20);
        graph.addEdge('C', 'D', 40);
        graph.addEdge('B', 'G', 30);
        graph.addEdge('E', 'G', 20);
        graph.addEdge('G', 'F', 20);
        graph.addEdge('D', 'F', 10);
        graph.addEdge('E', 'F', 30);
        graph.addEdge('D', 'G', 10);

        graph.minPath('A', 'F');
    }
}
