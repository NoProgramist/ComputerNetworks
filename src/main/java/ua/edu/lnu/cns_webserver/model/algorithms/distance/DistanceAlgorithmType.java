package ua.edu.lnu.cns_webserver.model.algorithms.distance;

public enum DistanceAlgorithmType {
	DIJKSTRA("Dijkstra"), BELLMAN_FORD("Bellman-Ford");

	private String name;

	DistanceAlgorithmType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
