package professor.profile;

import professor.mainMenu.ProfMainMenuPanel;
import profile.*;

public class ProfProfileUI extends ProfileUIMasterClass{
	private ProfMainMenuPanel profMainMenuPanel;
	public ProfProfileUI() {
		super();
		
		//ProfMainMenuPanel
		remove(getMainMenuPanel());
		profMainMenuPanel=new ProfMainMenuPanel();
		add(profMainMenuPanel);
	}

}
