package main;

import consultar.*;
import dbTools.DBMain;
import mainMenu.*;
import profile.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import professor.insert.*;
import professor.mainMenu.*;
import professor.profile.*;

import java.awt.*;

//TODO: Colocar nome da tela na interface do usuário

public class Main {
	public static MainUI mainUI;
	public static HomeMenuUI homeMenuUI;
	public static ConsultarUI consultarUI;
	public static ProfileUI profileUI;
	public static DBMain dbMain=new DBMain();
	
	//Se é na São José
	public static boolean isAcessoAtSaoJose=false;
	
	//PROFESSOR
	public static ProfHomeMenuUI profHomeMenuUI;
	public static ProfProfileUI profProfileUI; 
	public static ProfInsertUI profInsertUI;
	
	//isOn
	public static boolean isHomeMenuOnRAM=false;
	public static boolean isConsultarOnRAM=false;
	public static boolean isProfileOnRAM=false;
	
	//isOn Professor
	public static boolean isProfHomeMenuOnRAM=false;
	public static boolean isProfProfileOnRAM=false;
	public static boolean isProfInsertUIOnRAM=false;
	
	public static void main(String[] args) {
		mainUI=new MainUI();
		
		//mainUI.setVisible(false);
		//InsertNotasUI insertNotasUI=new InsertNotasUI();
		
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
			currentFrame.setVisible(false);
			consultarUI.setVisible(true);
			//Carregamento dos Dados do BD
			dbMain.consultarLoad("1111");
		}
		else {
			currentFrame.setVisible(false);
			consultarUI.setVisible(true);
		}
	}
	
	public static void startProfile(Window currentFrame) {
		if(!isProfileOnRAM) {
			profileUI=new ProfileUI();
			isProfileOnRAM=true;
			currentFrame.setVisible(false);
			profileUI.setVisible(true);
			
			//Carregamento dos dados do BD
			dbMain.profileLoad();
		}
		else {
			currentFrame.setVisible(false);
			profileUI.setVisible(true);
		}
	}
	
	//PROFESSOR
	
	public static void startProfHomeMenu(Window currentFrame) {
		if(!isProfHomeMenuOnRAM) {
			profHomeMenuUI=new ProfHomeMenuUI();
			isProfHomeMenuOnRAM=true;
		}
		currentFrame.setVisible(false);
		profHomeMenuUI.setVisible(true);
	}
	
	public static void startProfInsert(Window currentFrame) {
		if(!isProfInsertUIOnRAM) {
			profInsertUI=new ProfInsertUI();
			isProfInsertUIOnRAM=true;
			currentFrame.setVisible(false);
			profInsertUI.setVisible(true);
			
			//Carregamento de turmas (sem os alunos) do DB
			dbMain.profInsert_TurmaLoad();
		}
		else {
			currentFrame.setVisible(false);
			profInsertUI.setVisible(true);
		}
	}
	
	public static void startProfProfile(Window currentFrame) {
		if(!isProfProfileOnRAM) {
			profProfileUI=new ProfProfileUI();
			isProfProfileOnRAM=true;
			currentFrame.setVisible(false);
			profProfileUI.setVisible(true);
			
			//Carregamento dos dados do BD
			dbMain.profProfileLoad();
		}
		else {
			currentFrame.setVisible(false);
			profProfileUI.setVisible(true);
		}
	}
	
	//RESET ALL
	
	public static void resetAll() {
		//Lembre-se que a tela de login ainda continuará na RAM
		dbMain=null;
		dbMain=new DBMain();
		homeMenuUI=null;
		consultarUI=null;
		profileUI=null;
		//isOn
		isHomeMenuOnRAM=false;
		isConsultarOnRAM=false;
		isProfileOnRAM=false;
	}
	
	public static void resetAllProf() {
		//Lembre-se que a tela de login ainda continuará na RAM
		dbMain=null;
		dbMain=new DBMain();
		profHomeMenuUI=null;
		profProfileUI=null;
		//isOn
		isProfHomeMenuOnRAM=false;
		isProfProfileOnRAM=false;
	}
	
}
