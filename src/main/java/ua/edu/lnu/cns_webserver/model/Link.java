package ua.edu.lnu.cns_webserver.model;

public class Link {

	private Node source;

	private Node target;

	private boolean left;

	private boolean right;

	public Link() {
		super();
	}

	public Link(Node source, Node target, boolean left, boolean right) {
		super();
		this.source = source;
		this.target = target;
		this.left = left;
		this.right = right;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getTarget() {
		return target;
	}

	public void setTarget(Node target) {
		this.target = target;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}
