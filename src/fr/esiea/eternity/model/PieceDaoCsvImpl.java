package fr.esiea.eternity.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PieceDaoCsvImpl implements PieceDaoCsv {
	
	@Override
	public List<Piece> getAllPieces(String filename, List<Face> faces) {
		List<Piece> listPieces = new ArrayList<Piece>();
		File pieceFile = new File(filename);
		Scanner scanner;
		try {
			scanner = new Scanner(pieceFile);
			String input = "";
			while (scanner.hasNext()) {
				input = scanner.nextLine();
				String[] inputArray = input.split(" ");
				if (inputArray.length > 0 && inputArray[0].equals("#")) {
					continue;
				}
				else if (inputArray.length > 0 && inputArray[0].equals("P")) {
					int id = Integer.valueOf(inputArray[1]);
					Face northFace = null;
					Face eastFace = null;
					Face southFace = null;
					Face westFace = null;
					for (Face f : faces) {
						if (f.getId() == Integer.valueOf(inputArray[2])) {
							northFace = f;
						}
					}
					for (Face f : faces) {
						if (f.getId() == Integer.valueOf(inputArray[3])) {
							eastFace = f;
						}
					}
					for (Face f : faces) {
						if (f.getId() == Integer.valueOf(inputArray[4])) {
							southFace = f;
						}
					}
					for (Face f : faces) {
						if (f.getId() == Integer.valueOf(inputArray[5])) {
							westFace = f;
						}
					}
					Piece piece = new PieceImpl(id, northFace, eastFace, southFace, westFace);
					listPieces.add(piece);
				}
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		for (Piece p : listPieces) {
//			System.out.println(p);
//		}
		return listPieces;
	}
}
