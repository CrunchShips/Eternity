package fr.esiea.eternity.controller;

import fr.esiea.eternity.model.GameModel;
import fr.esiea.eternity.model.Grid;
import fr.esiea.eternity.view.GameView;

public class GameController {
	
	private GameModel model;
	private GameView view;
	
	public GameController() {
		super();
	}
	
	public GameModel getModel() {
		return this.model;
	}
	
	public void setModel(GameModel model) {
		this.model = model;
	}

	public GameView getVue() {
		return this.view;
	}

	public void setView(GameView view) {
		this.view = view;
	}
	
	public void notifyGameListChanged(Grid grid) {
		this.model.setGrid(grid);
	}
	
}
