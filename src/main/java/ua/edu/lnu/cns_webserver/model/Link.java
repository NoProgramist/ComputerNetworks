package ua.edu.lnu.cns_webserver.model;

public class Link {

	private int source;

	private int target;

	private boolean left;

	private boolean right;

	public Link() {
		super();
	}

	public Link(int source, int target, boolean left, boolean right) {
		super();
		this.source = source;
		this.target = target;
		this.left = left;
		this.right = right;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
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
