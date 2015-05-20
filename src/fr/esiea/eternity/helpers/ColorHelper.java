package fr.esiea.eternity.helpers;

import java.awt.*;
import java.util.Arrays;

public class ColorHelper {

	private String names[] = { "Black", "Blue", "Cyan", "Dark gray", "Gray",
			"Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White",
			"Yellow" };

	private Color colors[] = { Color.black, Color.blue, Color.cyan,
			Color.darkGray, Color.gray, Color.green, Color.lightGray,
			Color.magenta, Color.orange, Color.pink, Color.red, Color.white,
			Color.yellow };

	public ColorHelper() {
		super();
	}

	public Color getColor(String colorName) {
		colorName = colorName.substring(0, 1).toUpperCase()
				.concat(colorName.substring(1).toLowerCase());
		int index = Arrays.asList(this.names).indexOf(colorName);
		if (index >= 0 && index < names.length) {
			return this.colors[index];
		}
		return null;
	}

}
