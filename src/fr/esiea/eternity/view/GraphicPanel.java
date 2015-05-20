package fr.esiea.eternity.view;

import javax.swing.*;

import static fr.esiea.eternity.model.Constants.*;
import fr.esiea.eternity.model.Face;
import fr.esiea.eternity.model.Grid;
import fr.esiea.eternity.model.Orientation;
import fr.esiea.eternity.model.Piece;
import fr.esiea.eternity.model.Shape;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;


public class GraphicPanel extends JPanel implements ImageObserver {

	private static final long serialVersionUID = 1L;
	private Grid grid;

	public GraphicPanel(Grid grid) {
		this.grid = grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Grid getGrid() {
		return this.grid;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		

		List<Piece> pieces = this.grid.getPieces();
		List<Piece> piecesTable = this.grid.getTable();
		int w = PIECE_WIDTH;
		int h = PIECE_HEIGHT;
		int x = 0;
		int y = 0;
		Piece p = null;
		
		this.paintCommands(g);
		
		for (int i = 0; i < pieces.size(); i++) {
			p = pieces.get(i);
			x = p.getX() * w;
			y = p.getY() * h;
			this.paintPiece(g, g2d, p, x, y, w, h);
		}		

		for (int i = 0; i < piecesTable.size(); i++) {
			p = piecesTable.get(i);
			x = p.getX() * w;
			y = p.getY() * h;
			this.paintPiece(g, g2d, p, x + PIECE_WIDTH, y + PIECE_HEIGHT, w, h);
		}
		for (int i = 0; i < piecesTable.size(); i++) {
			p = piecesTable.get(i);
			x = p.getX() * w;
			y = p.getY() * h;
			this.paintTableAfter(g, g2d, p, x + PIECE_WIDTH, y + PIECE_HEIGHT, w, h);
		}
	}
	
	private void paintCommands(Graphics g) { 
	    Font f = new Font("SansSerif", Font.BOLD, 10);
	    g.setFont(f);
	    g.setColor(Color.white);
	    g.drawString("  Tourner vers", 0, PIECE_HEIGHT / 2 - 8);
	    g.drawString("     la gauche", 0, PIECE_HEIGHT / 2 + 12);
	    g.drawString("  Tourner vers", PIECE_WIDTH * 5, PIECE_HEIGHT / 2 - 8);
	    g.drawString("      la droite", PIECE_WIDTH * 5, PIECE_HEIGHT / 2 + 12);
	}

	private void paintTableAfter(Graphics g, Graphics2D g2d, Piece piece, int x, int y, int w,
			int h) {
		g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(x, y, x + w, y + h);
        g2d.drawLine(x, y + h, x + w, y);
        if (piece.isSelected()) {
        	g.setColor(Color.YELLOW);
        }
        else {
        	g.setColor(Color.WHITE);
        }
		g.drawRect(x, y, w, h);
	}

	private void paintPiece(Graphics g, Graphics2D g2d, Piece piece, int x, int y, int w, int h) {
		Face northFace = piece.getNorthFace();
		Face eastFace = piece.getEastFace();
		Face southFace = piece.getSouthFace();
		Face westFace = piece.getWestFace();

		if (piece.getOrientation().equals(Orientation.NORTH)) {
			this.paintBackground(g, northFace.getColor1(), Orientation.NORTH, x, y, w, h);
			this.paintShape(g, northFace.getShape(), northFace.getColor2(), Orientation.NORTH, x, y, w, h);
			
			this.paintBackground(g, eastFace.getColor1(), Orientation.EAST, x, y, w, h);
			this.paintShape(g, eastFace.getShape(), northFace.getColor2(), Orientation.EAST, x, y, w, h);
			
			this.paintBackground(g, southFace.getColor1(), Orientation.SOUTH, x, y, w, h);
			this.paintShape(g, southFace.getShape(), northFace.getColor2(), Orientation.SOUTH, x, y, w, h);
			
			this.paintBackground(g, westFace.getColor1(), Orientation.WEST, x, y, w, h);
			this.paintShape(g, westFace.getShape(), northFace.getColor2(), Orientation.WEST, x, y, w, h);
		}
		else if (piece.getOrientation().equals(Orientation.EAST)) {
			this.paintBackground(g, northFace.getColor1(), Orientation.EAST, x, y, w, h);
			this.paintShape(g, northFace.getShape(), northFace.getColor2(), Orientation.EAST, x, y, w, h);
			
			this.paintBackground(g, eastFace.getColor1(), Orientation.SOUTH, x, y, w, h);
			this.paintShape(g, eastFace.getShape(), northFace.getColor2(), Orientation.SOUTH, x, y, w, h);
			
			this.paintBackground(g, southFace.getColor1(), Orientation.WEST, x, y, w, h);
			this.paintShape(g, southFace.getShape(), northFace.getColor2(), Orientation.WEST, x, y, w, h);
			
			this.paintBackground(g, westFace.getColor1(), Orientation.NORTH, x, y, w, h);
			this.paintShape(g, westFace.getShape(), northFace.getColor2(), Orientation.NORTH, x, y, w, h);
		}
		else if (piece.getOrientation().equals(Orientation.SOUTH)) {
			this.paintBackground(g, northFace.getColor1(), Orientation.SOUTH, x, y, w, h);
			this.paintShape(g, northFace.getShape(), northFace.getColor2(), Orientation.SOUTH, x, y, w, h);
			
			this.paintBackground(g, eastFace.getColor1(), Orientation.WEST, x, y, w, h);
			this.paintShape(g, eastFace.getShape(), northFace.getColor2(), Orientation.WEST, x, y, w, h);
			
			this.paintBackground(g, southFace.getColor1(), Orientation.NORTH, x, y, w, h);
			this.paintShape(g, southFace.getShape(), northFace.getColor2(), Orientation.NORTH, x, y, w, h);
			
			this.paintBackground(g, westFace.getColor1(), Orientation.EAST, x, y, w, h);
			this.paintShape(g, westFace.getShape(), northFace.getColor2(), Orientation.EAST, x, y, w, h);
		}
		else if (piece.getOrientation().equals(Orientation.WEST)) {
			this.paintBackground(g, northFace.getColor1(), Orientation.WEST, x, y, w, h);
			this.paintShape(g, northFace.getShape(), northFace.getColor2(), Orientation.WEST, x, y, w, h);
			
			this.paintBackground(g, eastFace.getColor1(), Orientation.NORTH, x, y, w, h);
			this.paintShape(g, eastFace.getShape(), northFace.getColor2(), Orientation.NORTH, x, y, w, h);
			
			this.paintBackground(g, southFace.getColor1(), Orientation.EAST, x, y, w, h);
			this.paintShape(g, southFace.getShape(), northFace.getColor2(), Orientation.EAST, x, y, w, h);
			
			this.paintBackground(g, westFace.getColor1(), Orientation.SOUTH, x, y, w, h);
			this.paintShape(g, westFace.getShape(), northFace.getColor2(), Orientation.SOUTH, x, y, w, h);
		}
		g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(x, y, x + w, y + h);
        g2d.drawLine(x, y + h, x + w, y);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, w, h);
	}

	private void paintBackground(Graphics g, Color color, 
			Orientation orientation, int x, int y, int w, int h) {
		int[] xpoints;
		int[] ypoints;
		int midX = w / 2;
		int midY = h / 2;
		Polygon polygone;
		switch (orientation) {
		case NORTH:
			xpoints = new int[] { 
					x,
					x + w,
					x + midX };
			ypoints = new int[] { 
					y, 
					y,
					y + midY };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case EAST:
			xpoints = new int[] { 
					x + w, 
					x + w,
					x + w - midX };
			ypoints = new int[] { 
					y,
					y + h,
					y + midY };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case SOUTH:
			xpoints = new int[] { 
					x,
					x + w,
					x + midX };
			ypoints = new int[] { 
					y + h, 
					y + h,
					y + h - midY };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case WEST:
			xpoints = new int[] { 
					x, 
					x,
					x + midX };
			ypoints = new int[] { 
					y,
					y + h,
					y + midY };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		}
	}
	
	private void paintShape(Graphics g, Shape shape, Color color, 
			Orientation orientation, int x, int y, int w, int h) {
		
		switch (shape) {
			case ARROW:
				this.paintArrow(g, shape, color, orientation, x, y, w, h);
				break;
			case CIRCLE:
				break;
			case CROWN:
				this.paintCrown(g, shape, color, orientation, x, y, w, h);
				break;
			case LINES:
				this.paintLines(g, shape, color, orientation, x, y, w, h);
				break;
			case NONE:
				break;
			case SQUARE:
				this.paintSquare(g, shape, color, orientation, x, y, w, h);
				break;
			case TRIANGLE:
				this.paintTriangle(g, shape, color, orientation, x, y, w, h);
				break;
			case ZIGZAG:
				this.paintZigZag(g, shape, color, orientation, x, y, w, h);
				break;
		}
	}

	private void paintArrow(Graphics g, Shape shape, Color color,
			Orientation orientation, int x, int y, int w, int h) {
		int[] xpoints;
		int[] ypoints;
		int midX = w / 2;
		int midY = h / 2;
		int dx = 0;
		Polygon polygone;
		switch (orientation) {
		case NORTH:
			dx = 1;
			xpoints = new int[] { 
					x + midX + dx - (midX / 5), 
					x + midX + dx - (midX / 5),
					x + midX + dx - (midX / 3),  
					x + midX + dx, 
					x + midX + dx + (midX / 3), 
					x + midX + dx + (midX / 5), 
					x + midX + dx + (midX / 5) };
			ypoints = new int[] { 
					y, 
					y + (midY / 6 * 4),
					y + (midY / 6 * 4),
					y + midY,
					y + (midY / 6 * 4),
					y + (midY / 6 * 4),
					y };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case EAST:
			xpoints = new int[] { 
					x + w, 
					x + w - (midX / 6 * 4),
					x + w - (midX / 6 * 4),
					x + w - midX,
					x + w - (midX / 6 * 4),
					x + w - (midX / 6 * 4),
					x + w };
			ypoints = new int[] { 
					y + midY - (midY / 5), 
					y + midY - (midY / 5),
					y + midY - (midY / 3),  
					y + midY, 
					y + midY + (midY / 3), 
					y + midY + (midY / 5), 
					y + midY + (midY / 5) };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case SOUTH:
			xpoints = new int[] { 
					x + midX + dx - (midX / 5), 
					x + midX + dx - (midX / 5),
					x + midX + dx - (midX / 3),  
					x + midX + dx, 
					x + midX + dx + (midX / 3), 
					x + midX + dx + (midX / 5), 
					x + midX + dx + (midX / 5) };
			ypoints = new int[] { 
					y + h, 
					y + h - (midY / 6 * 4),
					y + h - (midY / 6 * 4),
					y + h - midY,
					y + h - (midY / 6 * 4),
					y + h - (midY / 6 * 4),
					y + h };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case WEST:
			xpoints = new int[] { 
					x, 
					x + (midX / 6 * 4),
					x + (midX / 6 * 4),
					x + midX,
					x + (midX / 6 * 4),
					x + (midX / 6 * 4),
					x };
			ypoints = new int[] { 
					y + midY - (midY / 5), 
					y + midY - (midY / 5),
					y + midY - (midY / 3),  
					y + midY, 
					y + midY + (midY / 3), 
					y + midY + (midY / 5), 
					y + midY + (midY / 5) };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		}
	}

	private void paintCrown(Graphics g, Shape shape, Color color, 
			Orientation orientation, int x, int y, int w, int h) {
		int[] xpoints;
		int[] ypoints;
		int midX = w / 2;
		int midY = h / 2;
		Polygon polygone;

		switch (orientation) {
		case NORTH:
			xpoints = new int[] { 
					x + midX + (midX / 6), 
					x + midX + (midX / 2),
					x + midX + (midX / 5),  
					x + midX, 
					x + midX - (midX / 5), 
					x + midX - (midX / 2), 
					x + midX - (midX / 6) };
			ypoints = new int[] { 
					y, 
					y + (midY / 3),
					y + (midY / 3),
					y + (midY / 2),
					y + (midY / 3),
					y + (midY / 3),
					y };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case EAST:
			xpoints = new int[] { 
					x, 
					x - (midX / 3),
					x - (midX / 3),
					x - (midX / 2),
					x - (midX / 3),
					x - (midX / 3),
					x };
			ypoints = new int[] { 
					y + midY + (midY / 6), 
					y + midY + (midY / 2),
					y + midY + (midY / 5),  
					y + midY, 
					y + midY - (midY / 5), 
					y + midY - (midY / 2), 
					y + midY - (midY / 6) };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case SOUTH:
			g.setColor(color);
			xpoints = new int[] { 
					x + midX + (midX / 6), 
					x + midX + (midX / 2),
					x + midX + (midX / 5),  
					x + midX, 
					x + midX - (midX / 5), 
					x + midX - (midX / 2), 
					x + midX - (midX / 6) };
			ypoints = new int[] { 
					y, 
					y - (midY / 3),
					y - (midY / 3),
					y - (midY / 2),
					y - (midY / 3),
					y - (midY / 3),
					y };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case WEST:
			xpoints = new int[] { 
					x, 
					x + (midX / 3),
					x + (midX / 3),
					x + (midX / 2),
					x + (midX / 3),
					x + (midX / 3),
					x };
			ypoints = new int[] { 
					y + midY + (midY / 6), 
					y + midY + (midY / 2),
					y + midY + (midY / 5),  
					y + midY, 
					y + midY - (midY / 5), 
					y + midY - (midY / 2), 
					y + midY - (midY / 6) };
			g.setColor(color);
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		}
	}

	private void paintLines(Graphics g, Shape shape, Color color,
			Orientation orientation, int x, int y, int w, int h) {
		int[] xpoints;
		int[] ypoints;
		int midX = w / 2;
		int midY = h / 2;
		int dx = 0;
		int dy = 0;
		Polygon polygone;
		
		switch (orientation) {
		case NORTH:
			dx = 1;
			g.setColor(color);
			xpoints = new int[] {
					x + midX + dx - (midX / 5 * 2),
					x + midX + dx - (midX / 5),
					x + midX + dx - (midX / 5),
					x + midX + dx - (midX / 5 * 2) };
			ypoints = new int[] { 
					y,
					y,
					y + (midY / 5 * 4),
					y + (midY / 5 * 3) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			xpoints = new int[] {
					x + midX + dx + (midX / 5),
					x + midX + dx + (midX / 5 * 2),
					x + midX + dx + (midX / 5 * 2),
					x + midX + dx + (midX / 5) };
			ypoints = new int[] { 
					y,
					y,
					y + (midY / 5 * 3),
					y + (midY / 5 * 4) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case EAST:
			dx = -1;
			dy = 1;
			g.setColor(color);
			xpoints = new int[] { 
					x + w,
					x + w,
					x + w + dx - (midX / 5 * 4),
					x + w + dx - (midX / 5 * 3) };
			ypoints = new int[] {
					y + midY + dy - (midY / 5 * 2),
					y + midY + dy - (midY / 5),
					y + midY + dy - (midY / 5),
					y + midY + dy - (midY / 5 * 2) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			xpoints = new int[] { 
					x + w,
					x + w,
					x + w + dx - (midX / 5 * 3),
					x + w + dx - (midX / 5 * 4) };
			ypoints = new int[] {
					y + midY + dy + (midY / 5),
					y + midY + dy + (midY / 5 * 2),
					y + midY + dy + (midY / 5 * 2),
					y + midY + dy + (midY / 5) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case SOUTH:
			dx = 1;
			dy = -1;
			g.setColor(color);
			xpoints = new int[] {
					x + midX + dx - (midX / 5 * 2),
					x + midX + dx - (midX / 5),
					x + midX + dx - (midX / 5),
					x + midX + dx - (midX / 5 * 2) };
			ypoints = new int[] { 
					y + h,
					y + h,
					y + h + dy - (midY / 5 * 4),
					y + h + dy - (midY / 5 * 3) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			xpoints = new int[] {
					x + midX + dx + (midX / 5),
					x + midX + dx + (midX / 5 * 2),
					x + midX + dx + (midX / 5 * 2),
					x + midX + dx + (midX / 5) };
			ypoints = new int[] { 
					y + h,
					y + h,
					y + h + dy - (midY / 5 * 3),
					y + h + dy - (midY / 5 * 4) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		case WEST:
			dx = 1;
			dy = 1;
			g.setColor(color);
			xpoints = new int[] { 
					x,
					x,
					x + dx + (midX / 5 * 4),
					x + dx + (midX / 5 * 3) };
			ypoints = new int[] {
					y + midY - (midY / 5 * 2),
					y + midY - (midY / 5),
					y + midY + dy - (midY / 5),
					y + midY + dy  - (midY / 5 * 2) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			xpoints = new int[] { 
					x,
					x,
					x + dx + (midX / 5 * 3),
					x + dx + (midX / 5 * 4) };
			ypoints = new int[] {
					y + midY + (midY / 5),
					y + midY + (midY / 5 * 2),
					y + midY + dy  + (midY / 5 * 2),
					y + midY + dy  + (midY / 5) };
			polygone = new Polygon(xpoints, ypoints, xpoints.length);
			g.fillPolygon(polygone);
			break;
		}
	}

	private void paintSquare(Graphics g, Shape shape, Color color,
			Orientation orientation, int x, int y, int w, int h) {
		int midX = w / 2;
		int midY = h / 2;
		g.setColor(color);
		
		switch (orientation) {
			case NORTH:
				g.fillRect(midX - (midX / 4), y, midX / 2, midY / 2);
				break;
			case EAST:
				g.fillRect(x + w - (midX / 2), midY - (midY / 4), midX / 2, midY / 2);
				break;
			case SOUTH:
				g.fillRect(midX - (midX / 4), h - (midY / 2), midX / 2, midY / 2);
				break;
			case WEST:
				g.fillRect(x, midY - (midY / 4), midX / 2, midY / 2);
				break;
		}
		
	}

	private void paintTriangle(Graphics g, Shape shape, Color color,
			Orientation orientation, int x, int y, int w, int h) {
		int[] xpoints;
		int[] ypoints;
		int midX = w / 2;
		int midY = h / 2;
		Polygon polygone;
		
		switch (orientation) {
			case NORTH:
				xpoints = new int[] { 
						x + midX / 2,
						x + w - (midX / 2),
						x + midX };
				ypoints = new int[] { 
						y,
						y,
						y + (midY / 2) };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
			case EAST:
				xpoints = new int[] { 
						x + w,
						x + w,
						x + w - (midX / 2) };
				ypoints = new int[] { 
						y + midY / 2,
						y + w - (midY / 2),
						y + midY };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
			case SOUTH:
				xpoints = new int[] { 
						x + midX / 2,
						x + w - (midX / 2),
						x + midX };
				ypoints = new int[] { 
						y + h,
						y + h,
						y + h - (midY / 2) };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
			case WEST:
				xpoints = new int[] { 
						x,
						x,
						x + (midX / 2) };
				ypoints = new int[] { 
						y + midY / 2,
						y + w - (midY / 2),
						y + midY };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
		}
	}
	
	private void paintZigZag(Graphics g, Shape shape, Color color,
			Orientation orientation, int x, int y, int w, int h) {
		int[] xpoints;
		int[] ypoints;
		int midX = w / 2;
		int midY = h / 2;
		int zigzagMin = 4;
		int zigzagMax = 10;
		Polygon polygone;
		
		switch (orientation) {
			case NORTH:
				xpoints = new int[] { 
						x + midX - (midX / zigzagMax),
						x + midX - (midX / zigzagMin),
						x + midX - (midX / zigzagMax),
						x + midX - (midX / zigzagMin),
						x + midX - (midX / zigzagMax),
						x + midX - (midX / zigzagMin),
						x + midX,
						x + midX + (midX / zigzagMin),
						x + midX + (midX / zigzagMax),
						x + midX + (midX / zigzagMin),
						x + midX + (midX / zigzagMax),
						x + midX + (midX / zigzagMin),
						x + midX + (midX / zigzagMax) };
				ypoints = new int[] { 
						y,
						y + midY / 6,
						y + midY / 6 * 2,
						y + midY / 6 * 3,
						y + midY / 6 * 4,
						y + midY / 6 * 5,
						y + midY,
						y + midY / 6 * 5,
						y + midY / 6 * 4,
						y + midY / 6 * 3,
						y + midY / 6 * 2,
						y + midY / 6,
						y };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
			case EAST:
				xpoints = new int[] { 
						x + w,
						x + w - midX / 6,
						x + w - midX / 6 * 2,
						x + w - midX / 6 * 3,
						x + w - midX / 6 * 4,
						x + w - midX / 6 * 5,
						x + w - midX,
						x + w - midX / 6 * 5,
						x + w - midX / 6 * 4,
						x + w - midX / 6 * 3,
						x + w - midX / 6 * 2,
						x + w - midX / 6,
						x + w };
				ypoints = new int[] { 
						y + midY - (midY / zigzagMax),
						y + midY - (midY / zigzagMin),
						y + midY - (midY / zigzagMax),
						y + midY - (midY / zigzagMin),
						y + midY - (midY / zigzagMax),
						y + midY - (midY / zigzagMin),
						y + midY,
						y + midY + (midY / zigzagMin),
						y + midY + (midY / zigzagMax),
						y + midY + (midY / zigzagMin),
						y + midY + (midY / zigzagMax),
						y + midY + (midY / zigzagMin),
						y + midY + (midY / zigzagMax) };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
			case SOUTH:
				xpoints = new int[] { 
						x + midX - (midX / zigzagMax),
						x + midX - (midX / zigzagMin),
						x + midX - (midX / zigzagMax),
						x + midX - (midX / zigzagMin),
						x + midX - (midX / zigzagMax),
						x + midX - (midX / zigzagMin),
						x + midX,
						x + midX + (midX / zigzagMin),
						x + midX + (midX / zigzagMax),
						x + midX + (midX / zigzagMin),
						x + midX + (midX / zigzagMax),
						x + midX + (midX / zigzagMin),
						x + midX + (midX / zigzagMax) };
				ypoints = new int[] { 
						y + h,
						y + h - midY / 6,
						y + h - midY / 6 * 2,
						y + h - midY / 6 * 3,
						y + h - midY / 6 * 4,
						y + h - midY / 6 * 5,
						y + h - midY,
						y + h - midY / 6 * 5,
						y + h - midY / 6 * 4,
						y + h - midY / 6 * 3,
						y + h - midY / 6 * 2,
						y + h - midY / 6,
						y + h };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
			case WEST:
				xpoints = new int[] { 
						x,
						x + midX / 6,
						x + midX / 6 * 2,
						x + midX / 6 * 3,
						x + midX / 6 * 4,
						x + midX / 6 * 5,
						x + midX,
						x + midX / 6 * 5,
						x + midX / 6 * 4,
						x + midX / 6 * 3,
						x + midX / 6 * 2,
						x + midX / 6,
						x };
				ypoints = new int[] { 
						y + midY - (midY / zigzagMax),
						y + midY - (midY / zigzagMin),
						y + midY - (midY / zigzagMax),
						y + midY - (midY / zigzagMin),
						y + midY - (midY / zigzagMax),
						y + midY - (midY / zigzagMin),
						y + midY,
						y + midY + (midY / zigzagMin),
						y + midY + (midY / zigzagMax),
						y + midY + (midY / zigzagMin),
						y + midY + (midY / zigzagMax),
						y + midY + (midY / zigzagMin),
						y + midY + (midY / zigzagMax) };
				g.setColor(color);
				polygone = new Polygon(xpoints, ypoints, xpoints.length);
				g.fillPolygon(polygone);
				break;
		}
	}
}








