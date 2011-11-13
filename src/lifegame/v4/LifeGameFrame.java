package lifegame.v4;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class LifeGameFrame extends JFrame implements ActionListener {
	LifeGamePanel mainPanel;
	JLabel genLabel;
	JButton startB, stepB, stopB;
	
	LifeGameFrame(){
		setTitle("Life Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container basePane = getContentPane();
		basePane.setLayout(new BorderLayout());
		
		JPanel genPanel = new JPanel();
		JLabel TitleLabel = new JLabel("Generation :");
		genLabel = new JLabel("0");
		genPanel.add(TitleLabel);
		genPanel.add(genLabel);
		basePane.add(genPanel, BorderLayout.NORTH);
		
		mainPanel = new LifeGamePanel(genLabel);
		basePane.add(mainPanel,BorderLayout.CENTER);
		
		startB = new JButton("Start");
		stepB = new JButton("Step");
		stopB = new JButton("Stop");
		startB.addActionListener(this);
		stepB.addActionListener(this);
		stopB.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(startB);
		buttonPanel.add(stepB);
		buttonPanel.add(stopB);
		basePane.add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startB) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					mainPanel.start();
				}
			});
		} else if(e.getSource() == stepB) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					mainPanel.step();
				}
			});
		}else if (e.getSource() == stopB) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					mainPanel.stop();
				}
			});
		}
	}
}
