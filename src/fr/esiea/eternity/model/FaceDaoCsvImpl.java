package fr.esiea.eternity.model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.esiea.eternity.helpers.ColorHelper;
import fr.esiea.eternity.helpers.ShapeHelper;

public class FaceDaoCsvImpl implements FaceDaoCsv {

	@Override
	public List<Face> getAllFace(String filename) {
		List<Face> listFaces = new ArrayList<Face>();
		File faceFile = new File(filename);
		Scanner scanner;
		try {
			scanner = new Scanner(faceFile);
			ColorHelper colorHelper = new ColorHelper();
			ShapeHelper shapeHelper = new ShapeHelper();
			String input = "";
			while (scanner.hasNext()) {
				int id = -1;
				Color color1 = null;
				Color color2 = null;
				Shape shape = null;
				input = scanner.nextLine();
				String[] inputArray = input.split(" ");
				if (inputArray.length > 0 && inputArray[0].equals("#")) {
					continue;
				}
				else if (inputArray.length > 0 && inputArray[0].equals("B")) {
					id = Integer.valueOf(inputArray[1]);
					color1 = colorHelper.getColor(inputArray[2]);
					color2 = colorHelper.getColor(inputArray[2]);
					shape = Shape.NONE;
				}
				else if (inputArray.length > 0 && inputArray[0].equals("F")) {
					id = Integer.valueOf(inputArray[1]);
					color1 = colorHelper.getColor(inputArray[2]);
					shape = shapeHelper.getShape(inputArray[3]);
					color2 = colorHelper.getColor(inputArray[4]);
				}
				Face face = new FaceImpl(id, color1, shape, color2);
				listFaces.add(face);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		for (Face f : listFaces) {
//			System.out.println(f);
//		}
//		System.out.println("\n");
		return listFaces;
	}

}
