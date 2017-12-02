package ua.edu.lnu.cns_webserver.model;

import java.util.Arrays;
import java.util.List;

public class Graph {

	private List<Node> nodes;

	private List<Link> links;

	public Graph() {
		this(Arrays.asList(), Arrays.asList());
	}

	public Graph(List<Node> nodes, List<Link> links) {
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
