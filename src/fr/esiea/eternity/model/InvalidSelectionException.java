package fr.esiea.eternity.model;

public class InvalidSelectionException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidSelectionException() {
		super();
	}
	
	public InvalidSelectionException(String message) {
		super(message);
	}
	
}
