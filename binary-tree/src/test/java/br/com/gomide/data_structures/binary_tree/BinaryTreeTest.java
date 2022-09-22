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
	void dontFindAnElement() {
		IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
		Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };
		
		Node<Integer> rootNode = binaryTreeOps.createTree(elements);
		
		Node<Integer> node = binaryTreeOps.getByElement(rootNode, 10);
		
		assertNull(node);
	}

}
