package ua.edu.lnu.cns_webserver.model.algorithms.traversal;

public enum TraversalAlgorithmType {
	BFS("Breadth-first search"), DFS("Depth-first search");

	private String name;

	TraversalAlgorithmType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
