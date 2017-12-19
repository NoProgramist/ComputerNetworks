package ua.edu.lnu.cns_webserver.model;

import ua.edu.lnu.computer_networks.algorithms.model.Vertex;

public class Node extends Vertex {

	private double x;

	private double y;

	private double px;

	private double py;

	public Node() {
		super(0, false);
	}

	public Node(int id, boolean reflexive) {
		super(id, reflexive);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getPx() {
		return px;
	}

	public void setPx(double px) {
		this.px = px;
	}

	public double getPy() {
		return py;
	}

	public void setPy(double py) {
		this.py = py;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", reflexive=" + reflexive + "]";
	}

}
