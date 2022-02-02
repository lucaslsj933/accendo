package professor.mainMenu;

import mainMenu.MainMenuPanelButtonsActionListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import main.Main;


public class ProfMainMenuPanelActionListener extends MainMenuPanelButtonsActionListener{
	
	public ProfMainMenuPanelActionListener(int buttonId) {
		super(buttonId);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Window currentFrame = SwingUtilities.windowForComponent((Component) e.getSource());
		
		if(getButtonId()==0) 
			Main.startHomeMenu(currentFrame);
		else if(getButtonId()==1)
			Main.startConsultar(currentFrame);
		else if(getButtonId()==2) 
			Main.startProfile(currentFrame);
		else if(getButtonId()==3) {
			Main.startMain(currentFrame);
			Main.resetAll();
		}
			
	}
}
