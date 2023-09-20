package br.com.gomide.graph.service;

import java.util.List;

import br.com.gomide.graph.model.DirectedGraph;
import br.com.gomide.graph.model.Graph;
import br.com.gomide.graph.model.NonDirectedGraph;

public class GraphService implements IGraphService {

  @Override
  public void addNodes(List<String> nodes, Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addNodes'");
  }

  @Override
  public void addNode(String node, Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addNode'");
  }

  @Override
  public void connectNode(String firstNode, String secondNode, Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'connectNode'");
  }

  @Override
  public void connectNode(String firstNode, String secondNode, Integer weight, Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'connectNode'");
  }

  @Override
  public int countLoops(Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'countLoops'");
  }

  @Override
  public int countMultipleLink(Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'countMultipleLink'");
  }

  @Override
  public int nodeDegree(String node, Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'nodeDegree'");
  }

  @Override
  public boolean isConnected(Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isConnected'");
  }

  @Override
  public boolean isComplete(Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isComplete'");
  }

  @Override
  public String showPath(String origin, String destination, DirectedGraph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showPath'");
  }

  @Override
  public String showPath(String origin, String destination, NonDirectedGraph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showPath'");
  }

  @Override
  public String showShortestPath(String origin, String destination, DirectedGraph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showShortestPath'");
  }

  @Override
  public String showShortestPath(String origin, String destination, NonDirectedGraph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showShortestPath'");
  }

  @Override
  public String toString(Graph graph) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toString'");
  }

}
