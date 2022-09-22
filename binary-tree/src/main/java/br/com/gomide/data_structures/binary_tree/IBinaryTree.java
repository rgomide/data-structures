package br.com.gomide.data_structures.binary_tree;

public interface IBinaryTree<T extends Comparable<?>> {

	/**
	 * Create a tree from a single element
	 * 
	 * @param element root element
	 * @return root node
	 */
	Node<T> createTree(T element);

	/**
	 * This method creates a new tree returning the root Node. The elements should
	 * be inserted from the first to last array element.
	 * 
	 * @param elements is an array of elements
	 * @return root node
	 */
	Node<T> createTree(T[] elements);

	/**
	 * Calculates the degree of a single Node
	 * 
	 * @param node
	 * @return degree value
	 */
	Integer degree(Node<T> node);

	/**
	 * Given a root node, inserts an element
	 * 
	 * @param rootNode
	 * @param element
	 */
	void insert(Node<T> rootNode, T element);

	/**
	 * Given a root node, removes an element
	 * 
	 * @param rootNode
	 * @param element
	 * @return
	 */
	boolean remove(Node<T> rootNode, T element);

	/**
	 * Get the father node
	 * 
	 * @param node
	 * @return returns the father node or null
	 */
	Node<T> getFather(Node<T> node);

	/**
	 * Get the brother node
	 * 
	 * @param node
	 * @return returns the brother node or null
	 */
	Node<T> getBrother(Node<T> node);

	/**
	 * Find and return a Node by element
	 * 
	 * @param rootNode
	 * @param element
	 * @return return the Node that contains the element or null
	 */
	Node<T> getByElement(Node<T> rootNode, T element);

	/**
	 * Calculate the tree depth
	 * 
	 * @param rootNode
	 * @return tree depth
	 */
	Integer calculateTreeDepth(Node<T> rootNode);

	/**
	 * Calculate the Node level
	 * 
	 * @param rootNode
	 * @param node
	 * @return node level
	 */
	Integer calculateNodeLevel(Node<T> rootNode, Node<T> node);

	/**
	 * Should use the String representation of a tree. This is an example for a
	 * Node<Integer> tree: 6(2(1 4(3)) 8)
	 * 
	 * @param node
	 * @return String representation of a tree.
	 */
	String toString(Node<T> rootNode);

}
