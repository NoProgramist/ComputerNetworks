package ua.edu.lnu.cns_webserver.model;

public class Node {

	private Long id;

	private boolean reflexive;

	public Node() {
		super();
	}

	public Node(Long id, boolean reflexive) {
		super();
		this.id = id;
		this.reflexive = reflexive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isReflexive() {
		return reflexive;
	}

	public void setReflexive(boolean reflexive) {
		this.reflexive = reflexive;
	}

}
