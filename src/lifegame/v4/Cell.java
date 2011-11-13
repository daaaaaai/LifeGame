package lifegame.v4;

import java.awt.*;

public class Cell {
	private boolean life;
	private int lifeAround;
	private CellLabel label;
	CellLabelEventHandler eh = new CellLabelEventHandler();
	
	public Cell() {
		life=false;
		lifeAround = 0;
		label = new CellLabel(this);
		label.addMouseListener(eh);
	}
	void setLifeAlive() {
		life = true;
		label.setAlive();
	}
	void setLifeDead() {
		life = false;
		label.setDead();
	}
	boolean getLife() {
		return life;
	}
	boolean isAlive() {
		return life;
	}
	void plusLA() {
		lifeAround++;
	}
	void resetLA() {
		lifeAround =0;
	}
	int getLA() {
		return lifeAround;
	}
	CellLabel getLabel() {
		return label;
	}
}
