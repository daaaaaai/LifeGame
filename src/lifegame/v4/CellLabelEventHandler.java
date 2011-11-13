package lifegame.v4;

import javax.swing.*;
import java.awt.event.*;

public class CellLabelEventHandler extends MouseAdapter {
	
	public void mouseClicked(MouseEvent me) {
		if(me.getSource() instanceof CellLabel) {
			CellLabel cl = (CellLabel) me.getSource();
			Cell cell = cl.getCell();
			if(cell.isAlive()) {
				cell.setLifeDead();
			} else {
				cell.setLifeAlive();
			}
			cl.getRootPane().repaint();
		}
	}
}
