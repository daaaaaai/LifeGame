package lifegame.v4;

import java.awt.*;
import javax.swing.*;

public class CellLabel extends JLabel {
	static CellIcon iconLive = new CellIcon(Color.WHITE, 10,10);
	static CellIcon iconDead = new CellIcon(Color.BLUE, 10,10);
	Cell cell;
	
	public CellLabel(Cell cell) {
		super();
		setDead();
		this.cell = cell;
	}
	
	void setAlive() {
		setIcon(iconLive);
	}
	
	void setDead() {
		setIcon(iconDead);
	}
	
	Cell getCell() {
		return cell;
	}
}