package fr.esiea.eternity.model;

public enum Shape {
	ARROW("arrow"),
	CIRCLE("circle"),
	CROWN("crown"),
	LINES("lines"),
	NONE("none"),
	SQUARE("square"),
	TRIANGLE("triangle"),
	ZIGZAG("zigzag");
	
	private String name;
	
	Shape(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}
