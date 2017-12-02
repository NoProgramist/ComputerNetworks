package ua.edu.lnu.cns_webserver.model;

public class Link {

	private Long source;

	private Long target;

	private boolean left;

	private boolean right;

	public Link() {
		super();
	}

	public Link(Long source, Long target, boolean left, boolean right) {
		super();
		this.source = source;
		this.target = target;
		this.left = left;
		this.right = right;
	}

	public Long getSource() {
		return source;
	}

	public void setSource(Long source) {
		this.source = source;
	}

	public Long getTarget() {
		return target;
	}

	public void setTarget(Long target) {
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
