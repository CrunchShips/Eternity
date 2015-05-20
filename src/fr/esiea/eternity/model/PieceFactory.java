package fr.esiea.eternity.model;

public class PieceFactory {

	public static final int PIECE = 2;
	
	public PieceFactory() {
		super();
	}
	
	public static Object create(int code) {
		switch (code) {
			case PIECE :
				Piece piece = new PieceImpl();
				return piece;
			default :
				return null;
		}
	}

}

