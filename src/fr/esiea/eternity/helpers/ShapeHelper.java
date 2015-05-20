package fr.esiea.eternity.helpers;

import fr.esiea.eternity.model.Shape;

public class ShapeHelper {
	
	public ShapeHelper() {
		super();
	}

	public Shape getShape(String shapeName) {
		for (int i = 0; i < Shape.values().length; i++) {
			Shape s = Shape.values()[i];
			String sName = s.getName();
			if (sName.equals(shapeName)) {
				return s;
			}
		}
		return null;
	}
}
