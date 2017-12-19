package ua.edu.lnu.cns_webserver.model.algorithms.traversal;

import java.util.List;

import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;
import ua.edu.lnu.cns_webserver.model.algorithms.AlgorithmParams;

public class TraversalAlgorithmParams extends AlgorithmParams {

	private int root;

	private TraversalAlgorithmType type;

	public TraversalAlgorithmParams() {
		super();
	}

	public TraversalAlgorithmParams(int root, TraversalAlgorithmType type) {
		super();
		this.root = root;
		this.type = type;
	}

	public TraversalAlgorithmParams(List<Node> nodes, List<Link> links, int root, TraversalAlgorithmType type) {
		super(nodes, links);
		this.root = root;
		this.type = type;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public TraversalAlgorithmType getType() {
		return type;
	}

	public void setType(TraversalAlgorithmType type) {
		this.type = type;
	}

}
