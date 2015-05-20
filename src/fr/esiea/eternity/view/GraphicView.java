package fr.esiea.eternity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import static fr.esiea.eternity.model.Constants.*;
import fr.esiea.eternity.controller.GameController;
import fr.esiea.eternity.model.Constants;
import fr.esiea.eternity.model.GameChangedEvent;
import fr.esiea.eternity.model.Grid;
import fr.esiea.eternity.model.InvalidSelectionException;
import fr.esiea.eternity.model.Piece;

public class GraphicView extends GameView implements View {

	private static final long serialVersionUID = 1L;
	private Grid grid;
	private GraphicPanel graphicPanel;
	private GameController controller;

	public GraphicView(GameController controller) {
		super(controller);
		this.controller = controller;
		this.grid = controller.getModel().getGrid();
		this.setTitle(" -ETERNITY- ");
		this.centerScreen(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.init();
		this.setVisible(true);
	}
	
	public void centerScreen(int w, int h) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
	    this.setBounds(x, y, w, h);
	}
	
	public void init() {
		this.setLayout(new BorderLayout());
		this.add(this.initGraphicPanel(), BorderLayout.CENTER);
//		this.initCommands();
		this.addMouseListener(new EternityMouseListener());
	}
	
	public GraphicPanel initGraphicPanel() {
		this.graphicPanel = new GraphicPanel(this.grid);
		return this.graphicPanel;
	}
	
//	public void initCommands() {
//		JButton btnRotateClockwise = new JButton("Tourner vers la droite");
//		btnRotateClockwise.setPreferredSize(new Dimension(Constants.PIECE_WIDTH, Constants.PIECE_HEIGHT));
//		this.add(btnRotateClockwise, BorderLayout.WEST);
//	}
	
	public void refresh(Grid grid) {
//		this.grid = grid;
		this.graphicPanel.setGrid(grid);
		this.graphicPanel.repaint();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void close() {
		this.dispose();
	}

	@Override
	public void gameChanged(GameChangedEvent event) {
		this.refresh(event.getGrid());
	}
	
	
	
	
	public class EternityMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			int mx = event.getX();
			int my = event.getY();
//			System.out.println("\nEternityMouseListener : (" + mx + ", " + my + ")");
			Point piecePosition = grid.getPiecePositionFromMouse(new Point(mx, my));
			Piece selectedPiece = grid.getSelectedPiece();
			if (piecePosition.x == 0 && piecePosition.y == 0) {
				if (selectedPiece != null) {
					grid.rotatePieceClockwise(selectedPiece);
				}
			}
			else if (piecePosition.y == 5 && piecePosition.y == 0) {
				if (selectedPiece != null) {
					grid.rotatePieceClockwise(selectedPiece);
				}
			}
			else {
				try {
					Piece piece = grid.getPieceClicked(new Point(mx, my));
					controller.notifyGameListChanged(grid);
					if (piece == null) {
						if (selectedPiece != null) {
							grid.setSelectedPiece(null);
							selectedPiece.setSelected(false);
							selectedPiece.setX(piecePosition.x);
							selectedPiece.setY(piecePosition.y);
							controller.notifyGameListChanged(grid);
						}
					}
					else {
//						System.out.println("EternityMouseListener : " + piece.toString());
						if (selectedPiece == null) {
							piece.setSelected(true);
							grid.setSelectedPiece(piece);
							controller.notifyGameListChanged(grid);
						}
						else {

						}
					}
				}
				catch (InvalidSelectionException ex) {
					System.err.println("Zone de sélection non valide");
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent event) {	
		}

		@Override
		public void mouseExited(MouseEvent event) {	
		}

		@Override
		public void mousePressed(MouseEvent event) {
		}

		@Override
		public void mouseReleased(MouseEvent event) {	
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
