package leetcode.graphic;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Joshua on 5/14/17.
 */
public class BFS {
    public static class Graph {
        final int edgeLength = 6;
        final int nodesCount;
        final Element[] graph;

        public class Element{
            int data;
            LinkedList<Element> adjacent = new LinkedList();

            public Element(int d) {
                this.data = d;
            }

            public void addAdjacent(Element e) {
                adjacent.add(e);
            }

            public boolean hasAdjacent(Element e) {
                return adjacent.contains(e);
            }

            public LinkedList<Element> getAdjacent() {
                return adjacent;
            }
        }

        public Graph(int size) {
            this.nodesCount = size;
            graph = new Element[size];
            for (int i=0; i< size; i++) {
                graph[i] = new Element(i);
            }
        }

        public Element getElement(int i) {
            if (i<0 || i>=nodesCount) {
                return null;
            }
            return graph[i];
        }

        public void addEdge(int first, int second) {
            Element firstElement = getElement(first);
            Element secondElement = getElement(second);
            if(false == firstElement.hasAdjacent(secondElement)) {
                firstElement.addAdjacent(secondElement);
            }
            if (false == secondElement.hasAdjacent(firstElement)) {
                secondElement.addAdjacent(firstElement);
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Stack<Element> stack = new Stack();
            Element start = getElement(startId);
            stack.push(start);

            int[] distance = new int[nodesCount];
            int[] visited = new int[nodesCount];
            for(int i=0;i<nodesCount;i++) {
                visited[i] = 0;
                distance[i] = -1;
            }
            //compare with those node one by one
            LinkedList<Element> list = start.getAdjacent();
            for (int i=0; i<list.size(); i++) {
                stack.push(list.get(i));
            }
            calculate(stack, 1, visited, distance);
            return distance;
        }

        public void calculate(Stack<Element> stack, int base, int[] visited, int[] distance) {
            Stack<Element> adjacentStack = new Stack();
            if (stack.isEmpty()) {
                return;
            }
            while(stack.isEmpty() == false) {
                Element adjacent = stack.pop();
                if (visited[adjacent.data] == 0) {
                    visited[adjacent.data] = 1;
                    distance[adjacent.data] = base*edgeLength;
                    LinkedList<Element> list = adjacent.getAdjacent();
                    for (int i=0; i<list.size(); i++) {
                        adjacentStack.push(list.get(i));
                    }
                }
            }
            calculate(adjacentStack, base+1, visited, distance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

