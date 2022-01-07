package main;

import consultar.*;
import dbTools.DBMain;
import mainMenu.*;
import profile.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;

//TODO: Colocar nome da tela na interface do usu�rio

public class Main {
	public static MainUI mainUI;
	public static HomeMenuUI homeMenuUI;
	public static ConsultarUI consultarUI;
	public static ProfileUI profileUI;
		
	//isOn
	public static boolean isHomeMenuOnRAM=false;
	public static boolean isConsultarOnRAM=false;
	public static boolean isProfileOnRAM=false;
	
	public static void main(String[] args) {
		mainUI=new MainUI();
	}
	
	public static void startMain(Window currentFrame) {
		currentFrame.setVisible(false);
		mainUI.setVisible(true);
	}
	
	public static void startHomeMenu(Window currentFrame) {
		if(!isHomeMenuOnRAM) {
			homeMenuUI=new HomeMenuUI();
			isHomeMenuOnRAM=true;
		}
		currentFrame.setVisible(false);
		homeMenuUI.setVisible(true);
	}
	
	public static void startConsultar(Window currentFrame) {
		if(!isConsultarOnRAM) {
			consultarUI=new ConsultarUI();
			isConsultarOnRAM=true;
		}
		currentFrame.setVisible(false);
		consultarUI.setVisible(true);
	}
	
	public static void startProfile(Window currentFrame) {
		if(!isProfileOnRAM) {
			profileUI=new ProfileUI();
			isProfileOnRAM=true;
			
			currentFrame.setVisible(false);
			profileUI.setVisible(true);
			
			//DB TESTE
			DBMain dbMain=new DBMain();
			dbMain.profileLoad("Lucas");
		}
		else {
			currentFrame.setVisible(false);
			profileUI.setVisible(true);
		}
	}
}
