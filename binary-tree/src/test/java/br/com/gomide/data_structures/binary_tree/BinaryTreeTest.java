package br.com.gomide.data_structures.binary_tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	@Test
	void createANewTree() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };
		Node<Integer> node = binaryTreeOps.createTree(elements);
		assertEquals(node.toString(), "6(2(1 4(3)) 8)");
	}

}
