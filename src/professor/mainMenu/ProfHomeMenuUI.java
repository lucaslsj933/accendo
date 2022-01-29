package professor.mainMenu;

import mainMenu.*;

public class ProfHomeMenuUI extends HomeMenuUI{
	private ProfMainMenuPanel profMainMenuPanel;
	
	public ProfHomeMenuUI(){
		super();
		getJlWelcome().setText("Bem vindo, Professor!");
		getJlWelcome().setBounds(1280/2-220,720/2-200,600,30);
		
		//ProfMainMenuPanel
		remove(getMainMenuPanel());
		profMainMenuPanel=new ProfMainMenuPanel();
		add(profMainMenuPanel);
	}
}
