package fr.esiea.eternity.model;

public interface Piece {

	int getId();
	Orientation getOrientation();
	void setOrientation(Orientation orientation);
	Face getNorthFace();
	Face getEastFace();
	Face getSouthFace();
	Face getWestFace();	
	int getX();
	int getY();	
	void setX(int x);
	void setY(int y);
	boolean isSelected();
	void setSelected(boolean isSelected);
	
}
