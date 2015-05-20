package fr.esiea.eternity.model;

import java.util.EventObject;

public class GameChangedEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private Grid grid;
	
	public GameChangedEvent(Object source, Grid grid) {
		super(source);
		this.grid = grid;
	}
	
	public Grid getGrid() {
		return this.grid;
	}	
}
