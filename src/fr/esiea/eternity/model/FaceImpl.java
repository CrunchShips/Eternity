package fr.esiea.eternity.model;

import java.awt.Color;

public class FaceImpl implements Face {
	
	private int id;
	private Color color1;
	private Shape shape;
	private Color color2;
	
	public FaceImpl() {
		super();
	}

	public FaceImpl(int id, Color color1, Shape shape, Color color2) {
		super();
		this.id = id;
		this.color1 = color1;
		this.shape = shape;
		this.color2 = color2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	@Override
	public String toString() {
		return "FaceImpl [id=" + id + ", color1=" + color1 + ", shape=" + shape
				+ ", color2=" + color2 + "]";
	}

	

	
	
	
}
