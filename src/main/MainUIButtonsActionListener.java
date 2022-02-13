package main;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import dbTools.LoginThread;

//LEMBRE-SE QUE O BUTTONID=1 É O ACESSO NA SÃO JOSÉ!

public class MainUIButtonsActionListener implements ActionListener{
	private int buttonId;
	
	public MainUIButtonsActionListener(int buttonId) {
		this.buttonId=buttonId;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(buttonId==0) {
			Main.isAcessoAtSaoJose=false;
			Main.dbMain.loginStart();
			//Window currentFrame = SwingUtilities.windowForComponent((Component) e.getSource());
			//Main.startHomeMenu(currentFrame);
		}
		else if(buttonId==1) {
			Main.isAcessoAtSaoJose=true;
			Main.dbMain.loginStart();
			//Window currentFrame = SwingUtilities.windowForComponent((Component) e.getSource());
			//Main.startHomeMenu(currentFrame);
		}
	}
}
