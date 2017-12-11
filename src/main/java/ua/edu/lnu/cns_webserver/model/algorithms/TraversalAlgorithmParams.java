package ua.edu.lnu.cns_webserver.model.algorithms;

import ua.edu.lnu.cns_webserver.model.Node;

public class TraversalAlgorithmParams {

	private Node root;

	private TraversalAlgorithmType type;

	public TraversalAlgorithmParams() {
		super();
	}

	public TraversalAlgorithmParams(Node root, TraversalAlgorithmType type) {
		super();
		this.root = root;
		this.type = type;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public TraversalAlgorithmType getType() {
		return type;
	}

	public void setType(TraversalAlgorithmType type) {
		this.type = type;
	}

}
