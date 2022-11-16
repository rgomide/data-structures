package br.com.gomide.data_structures.graph;

import java.util.List;

public interface IGraphService {

	public void addNodes(List<String> nodes, Graph graph);

	public void addNode(String node, Graph graph);

	public void connectNode(String firstNode, String secondNode, Graph graph);

	public int countLoops(Graph graph);

	public int countMultipleLink(Graph graph);

	public int nodeDegree(String node, Graph graph);

	public boolean isConnected(Graph graph);

	public boolean isComplete(Graph graph);

	public String showPath(String origin, String destination, DirectedGraph graph);

	public String showPath(String origin, String destination, NonDirectedGraph graph);

	public String toString(Graph graph);

}