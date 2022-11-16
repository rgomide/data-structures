package br.com.gomide.data_structures.graph;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GraphServiceTest {

	@Test
	void addNodes() {
		IGraphService graphService = new GraphService();
		Graph graph = new NonDirectedGraph();

		graphService.addNode(new Node("A"), graph);
		graphService.addNode(new Node("B"), graph);
		graphService.addNode(new Node("C"), graph);
		graphService.addNode(new Node("D"), graph);

		assertTrue(graphService.toString(graph).equals("Nodes: A B C D"));
	}

	@Test
	void addNodeList() {
		IGraphService graphService = new GraphService();
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

		graphService.addNodes(nodes, graph);

		assertTrue(graphService.toString(graph).equals("Nodes: A B C D"));
	}

	@Test
	void configureNonDirectedGraph() {
		IGraphService graphService = new GraphService();
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new DirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));
		nodes.add(new Node("E"));
		nodes.add(new Node("F"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new NonDirectedGraph();

		nodes.add(new Node("A"));
		nodes.add(new Node("B"));
		nodes.add(new Node("C"));
		nodes.add(new Node("D"));

		graphService.addNodes(nodes, graph);

		graphService.connectNode("A", "B", graph);
		graphService.connectNode("B", "C", graph);
		graphService.connectNode("C", "D", graph);
		graphService.connectNode("A", "C", graph);
		graphService.connectNode("B", "D", graph);

		assertFalse(graphService.isComplete(graph));
	}

}
