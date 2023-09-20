package br.com.gomide.graph.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.gomide.graph.model.DirectedGraph;
import br.com.gomide.graph.model.Graph;
import br.com.gomide.graph.model.NonDirectedGraph;

public class ShortestPathTest {
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

    graphService.connectNode("A", "B", 3, graph);
    graphService.connectNode("B", "C", 4, graph);
    graphService.connectNode("C", "D", 5, graph);
    graphService.connectNode("D", "A", 1, graph);
    graphService.connectNode("A", "C", 3, graph);

    String graphRepresentation = graphService.toString(graph);

    assertTrue(graphRepresentation.contains("Nodes: A B C D"));
    assertTrue(graphRepresentation.contains("Link: A B Weight: 3"));
    assertTrue(graphRepresentation.contains("Link: B C Weight: 4"));
    assertTrue(graphRepresentation.contains("Link: C D Weight: 5"));
    assertTrue(graphRepresentation.contains("Link: D A Weight: 1"));
    assertTrue(graphRepresentation.contains("Link: A C Weight: 3"));
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

    graphService.connectNode("A", "B", 3, graph);
    graphService.connectNode("B", "C", 4, graph);
    graphService.connectNode("C", "D", 5, graph);
    graphService.connectNode("D", "A", 1, graph);
    graphService.connectNode("A", "C", 3, graph);

    String graphRepresentation = graphService.toString(graph);

    assertTrue(graphRepresentation.contains("Nodes: A B C D"));
    assertTrue(graphRepresentation.contains("Link: A -> B Weight: 3"));
    assertTrue(graphRepresentation.contains("Link: B -> C Weight: 4"));
    assertTrue(graphRepresentation.contains("Link: C -> D Weight: 5"));
    assertTrue(graphRepresentation.contains("Link: D -> A Weight: 1"));
    assertTrue(graphRepresentation.contains("Link: A -> C Weight: 3"));
  }

  @Test
  void showAValidShortestPathForNonDirectedGraph() {
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

    graphService.connectNode("A", "B", 4, graph);
    graphService.connectNode("A", "C", 2, graph);
    graphService.connectNode("B", "C", 1, graph);
    graphService.connectNode("B", "D", 5, graph);
    graphService.connectNode("C", "D", 8, graph);
    graphService.connectNode("C", "E", 10, graph);
    graphService.connectNode("D", "E", 2, graph);
    graphService.connectNode("D", "F", 8, graph);
    graphService.connectNode("E", "F", 5, graph);

    String path = graphService.showShortestPath("A", "F", (NonDirectedGraph) graph);

    assertTrue(path.equals("Start -> A (2) C (1) B (5) D (2) E (5) F -> End"));
  }

  @Test
  void showAValidShortestPathForDirectedGraph() {
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

    graphService.connectNode("A", "B", 4, graph);
    graphService.connectNode("A", "C", 2, graph);
    graphService.connectNode("B", "D", 10, graph);
    graphService.connectNode("B", "C", 5, graph);
    graphService.connectNode("C", "E", 3, graph);
    graphService.connectNode("E", "D", 4, graph);
    graphService.connectNode("D", "F", 11, graph);

    String path = graphService.showShortestPath("A", "F", (DirectedGraph) graph);

    assertTrue(path.equals("Start -> A (2) C (3) E (4) D (11) F -> End"));
  }
}
