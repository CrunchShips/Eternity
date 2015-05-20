package fr.esiea.eternity.model;

public class PieceImpl implements Piece {
	
	private int id;
	private Face northFace;
	private Face eastFace;
	private Face southFace;
	private Face westFace;
	private Orientation orientation;
	private int x;
	private int y;
	private boolean isSelected;
	
	public PieceImpl() {
		super();
	}

	public PieceImpl(int id, Face northFace, Face eastFace, Face southFace,
			Face westFace) {
		super();
		this.id = id;
		this.northFace = northFace;
		this.eastFace = eastFace;
		this.southFace = southFace;
		this.westFace = westFace;
		this.orientation = Orientation.NORTH;
		this.x = 0;
		this.y = 0;
		this.isSelected = false;
	}

	public PieceImpl(int id, Face northFace, Face eastFace, Face southFace,
			Face westFace, Orientation orientation) {
		super();
		this.id = id;
		this.northFace = northFace;
		this.eastFace = eastFace;
		this.southFace = southFace;
		this.westFace = westFace;
		this.orientation = orientation;
		this.x = 0;
		this.y = 0;
		this.isSelected = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Face getNorthFace() {
		return northFace;
	}

	public void setNorthFace(Face northFace) {
		this.northFace = northFace;
	}

	public Face getEastFace() {
		return eastFace;
	}

	public void setEastFace(Face eastFace) {
		this.eastFace = eastFace;
	}

	public Face getSouthFace() {
		return southFace;
	}

	public void setSouthFace(Face southFace) {
		this.southFace = southFace;
	}

	public Face getWestFace() {
		return westFace;
	}

	public void setWestFace(Face westFace) {
		this.westFace = westFace;
	}

	@Override
	public Orientation getOrientation() {
		return this.orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	@Override
	public String toString() {
		return "PieceImpl [id=" + id + ", northFace=" + northFace
				+ ", eastFace=" + eastFace + ", southFace=" + southFace
				+ ", westFace=" + westFace + ", orientation=" + orientation
				+ ", x=" + x + ", y=" + y + ", isSelected=" + isSelected + "]";
	}

	
	
	
}
