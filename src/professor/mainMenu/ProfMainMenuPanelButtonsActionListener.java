package professor.mainMenu;

import mainMenu.MainMenuPanelButtonsActionListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import main.Main;


public class ProfMainMenuPanelButtonsActionListener implements ActionListener{
	private int buttonId;
	
	public ProfMainMenuPanelButtonsActionListener(int buttonId) {
		this.buttonId=buttonId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Window currentFrame = SwingUtilities.windowForComponent((Component) e.getSource());
		
		if(buttonId==0) 
			Main.startProfHomeMenu(currentFrame);
		else if(buttonId==1) 
			Main.startProfProfile(currentFrame);
		else if(buttonId==2) {
			Main.startMain(currentFrame);
			Main.resetAllProf();
		}
	}
}
