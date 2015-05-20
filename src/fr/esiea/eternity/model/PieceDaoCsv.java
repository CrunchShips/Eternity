package fr.esiea.eternity.model;

import java.util.List;

public interface PieceDaoCsv {

	List<Piece> getAllPieces(String filename, List<Face> faces);

}
