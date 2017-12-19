package ua.edu.lnu.cns_webserver.model.algorithms.distance;

import java.util.List;

import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;
import ua.edu.lnu.cns_webserver.model.algorithms.AlgorithmParams;

public class DistanceAlgorithmParams extends AlgorithmParams {

	private int root;

	private DistanceAlgorithmType type;

	public DistanceAlgorithmParams() {
		super();
	}

	public DistanceAlgorithmParams(int root, DistanceAlgorithmType type) {
		super();
		this.root = root;
		this.type = type;
	}

	public DistanceAlgorithmParams(List<Node> nodes, List<Link> links, int root, DistanceAlgorithmType type) {
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

	public DistanceAlgorithmType getType() {
		return type;
	}

	public void setType(DistanceAlgorithmType type) {
		this.type = type;
	}

}
