package lifegame.v4;

import java.awt.Event.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGamePanel extends JPanel implements ActionListener {
	public static final int YSIZE = Board.YSIZE;
	public static final int XSIZE = Board.XSIZE;
	public static final int SPACING = 2;
	
	Board board;
	Timer timer;
	int generation;
	JLabel genLabel;
	
	public LifeGamePanel(JLabel genLabel) {
		board = new Board();
		setLayout(new GridLayout(YSIZE, XSIZE, SPACING, SPACING));
		for(int y=0;y < YSIZE;y++) {
			for(int x=0;x<XSIZE ; x++) {
				CellLabel label = board.getCell(y+1,x+1).getLabel();
				add(label);
			}
		}
		this.genLabel = genLabel;
		generation = 0;
		timer = new Timer(200,this);
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void step() {
		board.countCellLife();
		board.nextGeneration();
		plusGeneration();
		repaint();
	}
	
	public void lifegame() {
		for(int gen = 0;gen < 9000;gen++) {
			board.countCellLife();
			board.nextGeneration();
			paintImmediately(getX(),getY(),getWidth(),getHeight());
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				
			}
		}
	}
	
	public void countCellLife() {
		board.countCellLife();
	}
	public void nextGeneration() {
		board.nextGeneration();
	}
	void plusGeneration() {
		generation++;
		genLabel.setText(String.valueOf(generation));
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			board.countCellLife();
			board.nextGeneration();
			plusGeneration();
			repaint();
		}
	}

}
