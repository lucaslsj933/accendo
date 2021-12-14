package main;

import consultar.*;
import mainMenu.*;

//Lembre-se que nos métodos start o visible do frame atual não é modificado

public class Main {
	public static MainUI mainUI;
	public static MainMenuPanel mainMenuPanel=new MainMenuPanel();
	public static ConsultarUI consultarUI;
		
	//isOn
	public static boolean isConsultarOnRAM=false;
	
	public static void main(String[] args) {
		mainUI=new MainUI();
	}
	
	public static void startConsultar() {
		if(!isConsultarOnRAM) {
			consultarUI=new ConsultarUI();
			isConsultarOnRAM=true;
		}
	}
}
