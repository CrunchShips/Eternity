package fr.esiea.eternity.model;

import java.util.EventListener;

public interface GameListener extends EventListener {
	public void gameChanged(GameChangedEvent event);
}
