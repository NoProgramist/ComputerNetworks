package ua.edu.lnu.cns_webserver.model;

public class Node {

	private int id;

	private boolean reflexive;

	public Node() {
		super();
	}

	public Node(int id, boolean reflexive) {
		super();
		this.id = id;
		this.reflexive = reflexive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isReflexive() {
		return reflexive;
	}

	public void setReflexive(boolean reflexive) {
		this.reflexive = reflexive;
	}

}
