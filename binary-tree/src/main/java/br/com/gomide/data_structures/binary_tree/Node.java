package br.com.gomide.data_structures.binary_tree;

public class Node<T extends Comparable> {

	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
