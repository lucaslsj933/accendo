package main;

import java.awt.event.*;

public class MainUIButtonsActionListener implements ActionListener{
	private int buttonId;
	
	public MainUIButtonsActionListener(int buttonId) {
		this.buttonId=buttonId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(buttonId==0) {
			Main.mainUI.setVisible(false);
			Main.startConsultar();
		}
	}
}
