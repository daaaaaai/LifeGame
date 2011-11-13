package lifegame.v4;

import java.awt.*;
import javax.swing.*;

public class LifeGameView extends JPanel{
	public static final int YSIZE = Board.YSIZE;
	public static final int XSIZE = Board.XSIZE;
	public static final int SPACING = 2;
	Board board;
	
	public LifeGameView() {
		board = new Board();
		setLayout(new GridLayout(YSIZE,XSIZE,SPACING,SPACING));
		for(int y=0;y < YSIZE ; y++) {
			for(int x = 0;x<XSIZE;x++) {
				CellLabel label = board.getCell(y+1,x+1).getLabel();
				add(label);
			}
		}
		CellLabelEventHandler eh = new CellLabelEventHandler();
		this.addMouseListener(eh);
	}
	public void lifegame() {
		for(int gen = 0;gen < 9000 ; gen++) {
			board.countCellLife();
			board.nextGeneration();
			repaint();
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
