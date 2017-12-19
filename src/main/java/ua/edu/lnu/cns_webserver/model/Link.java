package ua.edu.lnu.cns_webserver.model;

import ua.edu.lnu.computer_networks.algorithms.model.Edge;

public class Link extends Edge {

	public Link() {
		super(0, 0, false, false, 1);
	}

	public Link(int source, int target, boolean left, boolean right, double weight) {
		super(source, target, left, right, weight);
	}

	@Override
	public String toString() {
		return "Link [source=" + source + ", target=" + target + ", left=" + left + ", right=" + right + ", weight=" + weight + "]";
	}

}
