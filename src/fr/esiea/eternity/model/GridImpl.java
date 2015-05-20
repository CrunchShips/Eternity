package fr.esiea.eternity.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fr.esiea.eternity.model.Constants.*;

public class GridImpl implements Grid {
	
	private Dimension size;
	private List<Face> faces;
	private List<Piece> pieces;
	private List<Piece> table;
	private Piece selectedPiece;
	private final List<int[]> boardPositions = Arrays.asList(
			new int[] {1, 0},
			new int[] {2, 0},
			new int[] {3, 0},
			new int[] {4, 0},
			new int[] {5, 1},
			new int[] {5, 2},
			new int[] {5, 3},
			new int[] {5, 4},
			new int[] {4, 5},
			new int[] {3, 5},
			new int[] {2, 5},
			new int[] {1, 5},
			new int[] {0, 4},
			new int[] {0, 3},
			new int[] {0, 2},
			new int[] {0, 1} );
	
	public GridImpl() {
		super();
		this.size = new Dimension(GRID_WIDTH, GRID_HEIGHT);
		this.pieces = new ArrayList<Piece>((int) (this.size.getWidth() * this.size.getHeight()));
		this.table = new ArrayList<Piece>((int) (this.size.getWidth() * this.size.getHeight()));
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public List<Face> getFaces() {
		return faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

	public List<Piece> getTable() {
		return table;
	}

	public void setTable(List<Piece> table) {
		this.table = table;
	}
	
	@Override
	public String toString() {
		return "GridImpl [size=" + size + ", faces=" + faces + ", pieces="
				+ pieces + ", table=" + table + ", selectedPiece="
				+ selectedPiece + ", boardPositions=" + boardPositions + "]";
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	public void setPiece(Piece piece, int index) {
		this.table.add(index, piece);
	}
	
	public void removePieceAt(int index) {
		this.table.remove(index);
	}
	
	public void removePiece(Piece piece) {
		this.table.remove(piece);
	}
	
	public boolean isTileEmpty(int index) {
		return this.table.get(index) == null;
	}
	
	public void init() {
		for (int i = 0; i < this.pieces.size(); i++) {
			Piece p = this.pieces.get(i);
			p.setX(this.boardPositions.get(i)[0]);
			p.setY(this.boardPositions.get(i)[1]);
		}
	}
	
	public void rotatePieceClockwise(Piece piece) {
		switch (piece.getOrientation()) {
			case NORTH: piece.setOrientation(Orientation.EAST); break;
			case EAST: piece.setOrientation(Orientation.SOUTH); break;
			case SOUTH: piece.setOrientation(Orientation.WEST); break;
			case WEST: piece.setOrientation(Orientation.NORTH); break;
		}
	}
	
	public void rotatePieceCounterClockwise(Piece piece) {
		switch (piece.getOrientation()) {
			case NORTH: piece.setOrientation(Orientation.WEST); break;
			case EAST: piece.setOrientation(Orientation.NORTH); break;
			case SOUTH: piece.setOrientation(Orientation.EAST); break;
			case WEST: piece.setOrientation(Orientation.SOUTH); break;
		}
	}
	
	public boolean clickedOnTable(Point point) {
		int minX = PIECE_WIDTH;
		int minY = PIECE_HEIGHT;
		int maxX = PIECE_WIDTH * (this.size.width + 1);
		int maxY = PIECE_HEIGHT * (this.size.height + 1);
		return (point.x > minX && point.x < maxX && point.y > minY && point.y < maxY);
	}
	
	public Piece getPieceClicked(Point point) throws InvalidSelectionException {
		boolean clickedOnTable = this.clickedOnTable(point);
		if (clickedOnTable) {
			int col = point.x / PIECE_WIDTH;
			int row = point.y / PIECE_HEIGHT;
//			System.out.println("getPieceClicked on table : " + col + ", " + row);
			int i = 0;
			boolean found = false;
			Piece foundPiece = null;
			while (i < this.table.size() && !found) {
				Piece currentPiece = this.table.get(i);
				if (currentPiece.getX() == col && currentPiece.getY() == row) {
					foundPiece = currentPiece;
					found = true;
				}
				i++;
			}
			return foundPiece;
		}
		else {
			int col = point.x / PIECE_WIDTH;
			int row = point.y / PIECE_HEIGHT;
			if ((col == 0 && row == 0)  || (col == 5 && row == 0)
					|| (col >= 5 && row >= 5) || (col == 0 && row == 5)) {
//				System.out.println("getPieceClicked yes : " + col + ", " + row);
				throw new InvalidSelectionException();
			}
			else {
//				System.out.println("getPieceClicked no : " + col + ", " + row);
			}
			int i = 0;
			boolean found = false;
			Piece foundPiece = null;
			while (i < this.pieces.size() && !found) {
				Piece currentPiece = this.pieces.get(i);
				if (currentPiece.getX() == col && currentPiece.getY() == row) {
					foundPiece = currentPiece;
					found = true;
				}
				i++;
			}
			return foundPiece;
		}
	}
	
	public Point getPiecePositionFromMouse(Point mouse) {
		int col = mouse.x / PIECE_WIDTH;
		int row = mouse.y / PIECE_HEIGHT;
		return new Point(col, row);
	}

}
