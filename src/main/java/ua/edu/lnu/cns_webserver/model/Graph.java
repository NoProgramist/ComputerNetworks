package ua.edu.lnu.cns_webserver.model;

import java.util.Arrays;
import java.util.List;

import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public class Graph extends SimpleGraph {

	public Graph() {
		this(Arrays.asList(), Arrays.asList());
	}

	public Graph(List<Node> nodes, List<Link> links) {
		super(nodes, links);
	}

	@SuppressWarnings("unchecked")
	public List<Node> getNodes() {
		return (List<Node>) vertexes;
	}

	@SuppressWarnings("unchecked")
	public List<Link> getLinks() {
		return (List<Link>) edges;
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + vertexes + ", links=" + edges + "]";
	}

}
