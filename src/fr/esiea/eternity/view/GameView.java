package fr.esiea.eternity.view;

import javax.swing.JFrame;

import fr.esiea.eternity.controller.GameController;
import fr.esiea.eternity.model.GameListener;

public abstract class GameView extends JFrame implements View, GameListener {

	private static final long serialVersionUID = 1L;
	private GameController controller;
	
	public GameView (GameController controller) {
		this.controller = controller;
	}

	public GameController getController() {
		return this.controller;
	}

	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public abstract void display();
	public abstract void close();
}
