package main.java.com.datastructures.solutions.graphs;

import java.util.ArrayList;

class Graph{
    public ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
    public void addNode(GraphNode node)
    {
        nodes.add(node);
    }
}
class GraphNode{
    public int value;
    public GraphNode[] children;
    public GraphNode(int value)
    {
        this.value = value;
    }
    public void addChildren(GraphNode[] children)
    {
        this.children = children;
    }
}
public class RouteBetweenNodes {
    //find route between source and destination nodes
    public void findRoute(Graph graph, int source, int destination){
       GraphNode start = graph.nodes.get(source);
       GraphNode end = graph.nodes.get(destination);
       ArrayList<Boolean> visited = new ArrayList<Boolean>();

    }
    public static void main(String[] args) {
        RouteBetweenNodes route = new RouteBetweenNodes();
        Graph g = new Graph();

        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        node0.addChildren(new GraphNode[]{node1,node2});
        node1.addChildren(new GraphNode[]{node2,node3});
        node2.addChildren(new GraphNode[]{node3});
        node3.addChildren(new GraphNode[]{node1});

        System.out.println(node0.children[0].value);
        //route.findRoute(graph, 0, 3);

    }
}
