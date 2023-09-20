package br.com.gomide.graph.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.gomide.graph.model.DirectedGraph;
import br.com.gomide.graph.model.Graph;
import br.com.gomide.graph.model.NonDirectedGraph;

class GraphServiceTest {

  @Test
  void addNodes() {
    IGraphService graphService = new GraphService();
    Graph graph = new NonDirectedGraph();

    graphService.addNode("A", graph);
    graphService.addNode("A", graph);
    graphService.addNode("A", graph);
    graphService.addNode("B", graph);
    graphService.addNode("C", graph);
    graphService.addNode("C", graph);
    graphService.addNode("C", graph);
    graphService.addNode("D", graph);

    assertTrue(graphService.toString(graph).equals("Nodes: A B C D"));
  }

  @Test
  void addNodeList() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("B");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("D");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    assertTrue(graphService.toString(graph).equals("Nodes: A B C D"));
  }

  @Test
  void configureNonDirectedGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);

    String graphRepresentation = graphService.toString(graph);

    assertTrue(graphRepresentation.contains("Nodes: A B C D"));
    assertTrue(graphRepresentation.contains("Link: A B"));
    assertTrue(graphRepresentation.contains("Link: B C"));
    assertTrue(graphRepresentation.contains("Link: C D"));
    assertTrue(graphRepresentation.contains("Link: D A"));
    assertTrue(graphRepresentation.contains("Link: A C"));
  }

  @Test
  void configureDirectedGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new DirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);

    String graphRepresentation = graphService.toString(graph);

    assertTrue(graphRepresentation.contains("Nodes: A B C D"));
    assertTrue(graphRepresentation.contains("Link: A -> B"));
    assertTrue(graphRepresentation.contains("Link: B -> C"));
    assertTrue(graphRepresentation.contains("Link: C -> D"));
    assertTrue(graphRepresentation.contains("Link: D -> A"));
    assertTrue(graphRepresentation.contains("Link: A -> C"));
  }

  @Test
  void countThreeLoops() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("A", "A", graph);
    graphService.connectNode("B", "B", graph);
    graphService.connectNode("C", "C", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);

    assertEquals(graphService.countLoops(graph), 3);
  }

  @Test
  void countTwooMultipleLinks() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);

    assertEquals(graphService.countMultipleLink(graph), 2);
  }

  @Test
  void checkAllNodeDegrees() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);

    assertEquals(graphService.nodeDegree("A", graph), 4);
    assertEquals(graphService.nodeDegree("B", graph), 3);
    assertEquals(graphService.nodeDegree("C", graph), 3);
    assertEquals(graphService.nodeDegree("D", graph), 2);
  }

  @Test
  void checkConnectedGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);

    assertTrue(graphService.isConnected(graph));
  }

  @Test
  void checkDisconnectedGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);
    graphService.connectNode("E", "F", graph);

    assertFalse(graphService.isConnected(graph));
  }

  @Test
  void checkCompleteGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "A", graph);
    graphService.connectNode("A", "C", graph);
    graphService.connectNode("B", "D", graph);

    assertTrue(graphService.isComplete(graph));
  }

  @Test
  void checkUncompleteGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("A", "C", graph);
    graphService.connectNode("B", "D", graph);

    assertFalse(graphService.isComplete(graph));
  }

  @Test
  void showAValidPathForNonDirectedGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "E", graph);
    graphService.connectNode("E", "F", graph);

    graphService.connectNode("B", "D", graph);
    graphService.connectNode("C", "E", graph);

    String path = graphService.showPath("A", "F", (NonDirectedGraph) graph);

    assertTrue(path.startsWith("Start -> A B"));
    assertTrue(path.endsWith("E F -> End"));
  }

  @Test
  void showAValidPathForDirectedGraph() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new DirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "E", graph);
    graphService.connectNode("E", "F", graph);

    graphService.connectNode("D", "B", graph);
    graphService.connectNode("E", "C", graph);

    String path = graphService.showPath("A", "F", (DirectedGraph) graph);

    assertTrue(path.startsWith("Start -> A B"));
    assertTrue(path.endsWith("E F -> End"));
  }

  @Test
  void doesNotShowAPathForNonDirectedGraphBecauseIsInvalid() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new NonDirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");
    nodes.add("G");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "E", graph);
    graphService.connectNode("E", "F", graph);

    graphService.connectNode("B", "D", graph);
    graphService.connectNode("C", "E", graph);

    String path = graphService.showPath("A", "G", (NonDirectedGraph) graph);

    assertTrue(path.equals("INVALID PATH"));
  }

  @Test
  void doesNotShowAPathForDirectedGraphBecauseIsInvalid() {
    IGraphService graphService = new GraphService();
    List<String> nodes = new ArrayList<>();
    Graph graph = new DirectedGraph();

    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");
    nodes.add("G");

    graphService.addNodes(nodes, graph);

    graphService.connectNode("A", "B", graph);
    graphService.connectNode("B", "C", graph);
    graphService.connectNode("C", "D", graph);
    graphService.connectNode("D", "E", graph);
    graphService.connectNode("E", "F", graph);
    graphService.connectNode("G", "F", graph);

    graphService.connectNode("B", "D", graph);
    graphService.connectNode("C", "E", graph);

    String path = graphService.showPath("A", "G", (DirectedGraph) graph);

    assertTrue(path.equals("INVALID PATH"));
  }

}
