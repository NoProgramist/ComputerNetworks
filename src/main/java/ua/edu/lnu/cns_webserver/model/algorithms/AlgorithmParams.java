package ua.edu.lnu.cns_webserver.model.algorithms;

import java.util.List;

import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;

public class AlgorithmParams {

	private List<Node> nodes;

	private List<Link> links;

	public AlgorithmParams() {
		super();
	}

	public AlgorithmParams(List<Node> nodes, List<Link> links) {
		super();
		this.nodes = nodes;
		this.links = links;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
