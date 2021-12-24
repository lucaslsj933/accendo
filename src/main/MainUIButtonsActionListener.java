package main;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.*;

import javax.swing.SwingUtilities;

public class MainUIButtonsActionListener implements ActionListener{
	private int buttonId;
	
	public MainUIButtonsActionListener(int buttonId) {
		this.buttonId=buttonId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(buttonId==0) {
			Window currentFrame = SwingUtilities.windowForComponent((Component) e.getSource());
			Main.startHomeMenu(currentFrame);
		}
	}
}
