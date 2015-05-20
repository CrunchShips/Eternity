package fr.esiea.eternity.model;

import javax.swing.event.EventListenerList;

public class GameModel extends GameImpl {

	private EventListenerList listeners;

	public GameModel() {
		super();
		this.listeners = new EventListenerList();
//		super.initFacesAndPieces();
	}

	public void setGrid(Grid grid) {
		super.setGrid(grid);
		this.fireGameChanged();
	}

	public void addGameListener(GameListener l) {
		this.listeners.add(GameListener.class, l);
	}
	
	public void removerGameListener (GameListener l) {
		this.listeners.remove(GameListener.class, l);
	}
	
	public void fireGameChanged() {
		GameListener[] listenerList = (GameListener[]) this.listeners.getListeners(GameListener.class);
		for (GameListener listener : listenerList) {
			listener.gameChanged(new GameChangedEvent(this, this.getGrid()));
		}
	}
}
