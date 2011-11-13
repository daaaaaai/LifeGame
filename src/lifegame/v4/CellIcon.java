package lifegame.v4;

import java.awt.*;
import javax.swing.*;

public class CellIcon implements Icon{
	int width,height;
	Color color;
	
	public CellIcon(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	public int getIconHeight() {
		return height;
	}
	
	public int getIconWidth() {
		return width;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
