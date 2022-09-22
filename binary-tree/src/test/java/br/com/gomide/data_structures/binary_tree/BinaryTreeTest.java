package br.com.gomide.data_structures.binary_tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	@Test
	void createANewTree() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		assertEquals(binaryTreeOps.toString(rootNode), "6(2(1 4(3)) 8)");
	}

	@Test
	void getAnElement() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		Node<Integer> node = binaryTreeOps.getByElement(rootNode, 8);

		assertEquals(node.getValue(), 8);
	}

	@Test
	void dontFindRequiredElement() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		Node<Integer> node = binaryTreeOps.getByElement(rootNode, 10);

		assertNull(node);
	}

	@Test
	void checkNodeDegree() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		Node<Integer> node = binaryTreeOps.getByElement(rootNode, 8);
		assertEquals(binaryTreeOps.degree(node), 0);

		node = binaryTreeOps.getByElement(rootNode, 2);
		assertEquals(binaryTreeOps.degree(node), 2);

		node = binaryTreeOps.getByElement(rootNode, 4);
		assertEquals(binaryTreeOps.degree(node), 1);

		assertNull(binaryTreeOps.degree(null));
	}

	@Test
	void getFather() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		Node<Integer> node = binaryTreeOps.getByElement(rootNode, 8);
		assertEquals(binaryTreeOps.getFather(node).getValue(), 6);

		node = binaryTreeOps.getByElement(rootNode, 1);
		assertEquals(binaryTreeOps.getFather(node).getValue(), 2);

		node = binaryTreeOps.getByElement(rootNode, 6);
		assertNull(binaryTreeOps.getFather(node));
	}

	@Test
	void getBrother() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		Node<Integer> node = binaryTreeOps.getByElement(rootNode, 8);
		assertEquals(binaryTreeOps.getBrother(node).getValue(), 2);

		node = binaryTreeOps.getByElement(rootNode, 3);
		assertNull(binaryTreeOps.getBrother(node));
	}

	@Test
	void calculateTreeDepths() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

		Node<Integer> rootNode = binaryTreeOps.createTree(elements);

		assertEquals(binaryTreeOps.calculateTreeDepth(rootNode), 3);
	}

}
