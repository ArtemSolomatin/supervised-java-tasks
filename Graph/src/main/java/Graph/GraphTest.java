package Graph;


/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 */
public class GraphTest {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addNode('A', 10);
        graph.addNode('B', 20);
        graph.addNode('C', 5);
        graph.addNode('D', 25);
        graph.addNode('E', 15);
        graph.addNode('F', 30);
        graph.addNode('E', 20);
        graph.addNode('G', 50);

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
