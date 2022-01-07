package mainMenu;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import main.Main;

public class MainMenuPanelButtonsActionListener implements ActionListener{
	private int buttonId;
	
	public MainMenuPanelButtonsActionListener(int buttonId) {
		this.buttonId=buttonId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Window currentFrame = SwingUtilities.windowForComponent((Component) e.getSource());
		
		if(buttonId==0) 
			Main.startHomeMenu(currentFrame);
		else if(buttonId==1)
			Main.startConsultar(currentFrame);
		else if(buttonId==2) 
			Main.startProfile(currentFrame);
		else if(buttonId==3)
			Main.startMain(currentFrame);
	}
}
