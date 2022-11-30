package br.com.gomide.data_structures.graph.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import br.com.gomide.data_structures.graph.model.DirectedGraph;
import br.com.gomide.data_structures.graph.model.Graph;
import br.com.gomide.data_structures.graph.model.NonDirectedGraph;

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
}
