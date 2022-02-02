package professor.profile;

import professor.mainMenu.ProfMainMenuPanel;
import profile.*;

public class ProfProfileUI extends ProfileUI{
	private ProfMainMenuPanel profMainMenuPanel;
	public ProfProfileUI() {
		super();
		remove(getJlSerie()); remove(getJlSerieInput());
		remove(getJlEtapa()); remove(getJlEtapaInput());
		remove(getJlTurma()); remove(getJlTurmaInput());
		
		//ProfMainMenuPanel
		remove(getMainMenuPanel());
		profMainMenuPanel=new ProfMainMenuPanel();
		add(profMainMenuPanel);
	}

}
