package fr.esiea.eternity.view;

import java.awt.Dimension;

import fr.esiea.eternity.model.Grid;

public class ConsoleView implements View {
	
	private Grid grid;
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "ConsoleView [grid=" + grid + "]";
	}

	@Override
	public void display() {
		String sgrid = "";
		StringBuilder builder = new StringBuilder();
		Dimension dim = this.grid.getSize();
		for (int i = 0; i < dim.getWidth(); i++) {
			builder.append("__");
		}
		builder.append("\n");
		for (int i = 0; i < dim.getWidth(); i++) {
			builder.append("|");
			for (int j = 0; j < dim.getHeight(); j++) {
				builder.append(" ");
				builder.append("|");
			}
			builder.append("\n");
		}
		
		sgrid = builder.toString();
		System.out.println(sgrid);
	}

	@Override
	public void close() {
		
	}


}
