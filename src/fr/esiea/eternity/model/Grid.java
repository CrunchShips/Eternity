package fr.esiea.eternity.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import fr.esiea.eternity.model.Piece;

public interface Grid {

	Dimension getSize();

	void setFaces(List<Face> faces);
	
	List<Face> getFaces();

	void setPieces(List<Piece> pieces);

	List<Piece> getPieces();

	List<Piece> getTable();
	
	void init();

	Piece getPieceClicked(Point point) throws InvalidSelectionException;
	
	Piece getSelectedPiece();

	void setSelectedPiece(Piece selectedPiece);
	
	Point getPiecePositionFromMouse(Point mouse);
	
	void rotatePieceClockwise(Piece piece);
	
	void rotatePieceCounterClockwise(Piece piece);
}
