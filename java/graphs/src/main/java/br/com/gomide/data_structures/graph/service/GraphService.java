package br.com.gomide.data_structures.graph.service;

import java.util.List;

import br.com.gomide.data_structures.graph.model.DirectedGraph;
import br.com.gomide.data_structures.graph.model.Graph;
import br.com.gomide.data_structures.graph.model.NonDirectedGraph;

public class GraphService implements IGraphService {

	@Override
	public void addNodes(List<String> nodes, Graph graph) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNode(String node, Graph graph) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectNode(String firstNode, String secondNode, Graph graph) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectNode(String firstNode, String secondNode, Integer weight, Graph graph) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countLoops(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countMultipleLink(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nodeDegree(String node, Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isConnected(Graph graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete(Graph graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String showPath(String origin, String destination, DirectedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showPath(String origin, String destination, NonDirectedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showShortestPath(String origin, String destination, DirectedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showShortestPath(String origin, String destination, NonDirectedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

}
