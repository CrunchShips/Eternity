package fr.esiea.eternity.model;

import java.util.List;

public class GameImpl implements Game {
	
	private Grid grid;
	private FaceDaoCsv faceDaoCsv;
	private PieceDaoCsv pieceDaoCsv;
	
	public GameImpl() {
		super();
		this.faceDaoCsv = new FaceDaoCsvImpl();
		this.pieceDaoCsv = new PieceDaoCsvImpl();
		this.grid = new GridImpl();
		this.grid.setFaces(this.loadFaces("faces-01.csv"));
		this.grid.setPieces(this.loadPieces("pieces-01.csv", this.grid.getFaces()));
		this.grid.init();
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "GameImpl [grid=" + grid + "]";
	}

	private List<Face> loadFaces(String filename) {
		return this.faceDaoCsv.getAllFace(filename);
	}

	private List<Piece> loadPieces(String filename, List<Face> faces) {
		return this.pieceDaoCsv.getAllPieces(filename, faces);
	}
	
}
