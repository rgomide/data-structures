package br.com.gomide.data_structures.graph;

import java.util.List;

public interface IGraphService {

	public void addNodes(List<Node> node, Graph graph);

	public void addNode(Node node, Graph graph);

	public void connectNode(Node firstNode, Node secondNode, Graph graph);

	public int countLoops(Graph graph);

	public int countMultipleLink(Graph graph);

	public int nodeDegree(Node node, Graph graph);

	public boolean isConnected(Graph graph);

	public boolean isComplete(Graph graph);

	public String showPath(Node origin, Node destination, DirectedGraph graph);

	public String showPath(Node origin, Node destination, NonDirectedGraph graph);

	public String toString(Graph graph);

}