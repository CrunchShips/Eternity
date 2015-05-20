package fr.esiea.eternity;

import fr.esiea.eternity.controller.GameController;
import fr.esiea.eternity.model.GameModel;
import fr.esiea.eternity.view.GameView;
import fr.esiea.eternity.view.GraphicView;

public class Main {

	public static void main(String[] args) {
		

		// Model
		GameModel model = new GameModel();

		GameController controller = new GameController();
		controller.setModel(model);
		
		// View
		GameView view = new GraphicView(controller);
		model.addGameListener(view);
		view.display();
		
		// Controller
		controller.setView(view);
		view.setController(controller);
		
		
		
	}
}
