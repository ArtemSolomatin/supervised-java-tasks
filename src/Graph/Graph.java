package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Created by Artem Solomatin on 06.07.17.
 * SupervisedProjects
 */
public class Graph {
    private static final int MAX_NODES = 10;
    private static final int INFINITY = 1000_000;

    private ArrayList<Node> nodes = new ArrayList<Node>(MAX_NODES);
    private int[][] adjMatrix = new int[MAX_NODES][MAX_NODES];
    private Column[] pathMatrix;

    private int numNodes;
    private int nTree;

    private int currentNode;
    private int startToCurrentDistance;

    Graph() {
        adjMatrix = new int[MAX_NODES][MAX_NODES];
        numNodes = 0;
        nTree = 0;
        int i, j;
        for(i = 0;i < MAX_NODES;i++){
            for(j = 0;j < MAX_NODES;j++){
                adjMatrix[i][j] = INFINITY;
            }
        }
        pathMatrix = new Column[MAX_NODES];
    }

    public void addNode(char name, int cost){
        nodes.add(numNodes++, new Node(name, cost));
    }

    public void addEdge(char startName, char endName, int weight){
        int start = findNumberInNodes(startName);
        int end = findNumberInNodes(endName);
        adjMatrix[start][end] = weight;
    }

    private int findNumberInNodes(char c){
        for(Node n:nodes){
            if(n.getName() == c){
                return nodes.indexOf(n);
            }
        }
        throw new NoSuchElementException();
    }

    public void minPath(char first, char last) {
        int firstNode = findNumberInNodes(first);
        int lastNode = findNumberInNodes(last);

        int startTree = 0;
        nodes.get(startTree).setInTree(true);
        nTree = 1;

        for(int i = 0;i < numNodes;i++){         //перемещение строки состояний из adjMatrix в pathMatrix
            int tempDist = adjMatrix[startTree][i];
            pathMatrix[i] = new Column(startTree, tempDist);
        }

        while (nTree < numNodes){
            int indexMin = getMin();
            int minDist = pathMatrix[indexMin].getDistance();

            if(minDist == INFINITY){
                System.out.println("Недосягаемая вершина");
                break;
            }else{                                  //возврат currentNode к ближайшей вершине
                currentNode = indexMin;
                startToCurrentDistance = pathMatrix[indexMin].getDistance();
            }
            nodes.get(currentNode).setInTree(true);
            nTree++;
            update();
        }

        routing(firstNode, lastNode);

        nTree = 0;
        for(int i = 0;i < numNodes;i++){
            nodes.get(i).setInTree(false);
        }
    }

    private int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;

        for(int i = 1;i < numNodes;i++){
            if(!nodes.get(i).isInTree() && pathMatrix[i].getDistance() < minDist){
                minDist = pathMatrix[i].getDistance();
                indexMin = i;
            }
        }
        return indexMin;
    }

    private void update(){         //обновление в массиве кратчайших путей
        int column = 1;

        while(column < numNodes){
            if(nodes.get(column).isInTree()){
                column++;
                continue;
            }
            int startToFringe = startToCurrentDistance + adjMatrix[currentNode][column] + nodes.get(currentNode).getCost();
            int pathMatrixDist = pathMatrix[column].getDistance();

            if(startToFringe < pathMatrixDist){
                pathMatrix[column].setParent(currentNode);
                pathMatrix[column].setDistance(startToFringe);
            }
            column++;
        }
    }

    private void routing(int startNode, int finishNode){
        if(startNode == finishNode){
            System.out.println("Маршрут начинается и заканчивается в одном узле");
        }

        int number = finishNode;
        ArrayList<Character> parents = new ArrayList<>(MAX_NODES);
        while(number != startNode){
            parents.add(nodes.get(number).getName());
            number = pathMatrix[number].getParent();
        }

        parents.add(nodes.get(number).getName());
        Collections.reverse(parents);


        System.out.print("Минимальный путь от " + nodes.get(startNode).getName() + " к " + nodes.get(finishNode).getName() + " лежит через ");
        for(Character c:parents){
            System.out.print(c);
        }
        System.out.println(" и составляет " + pathMatrix[finishNode].getDistance() + " единиц");
    }
}
