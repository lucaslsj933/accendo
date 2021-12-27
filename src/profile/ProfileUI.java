package profile;

import javax.swing.*;
import mainMenu.MainMenuPanel;
import java.awt.Font;

public class ProfileUI extends JFrame{
	private Font bodyFont=new Font("Arial", Font.PLAIN, 20);
	
	private MainMenuPanel mainMenuPanel;
	private JLabel profileImg,jlName,jlNameInput,jlSexo,jlSexoInput;
	
	//Lembre-se que o jlInput fica 5 pixels depois da label não-input
	//Separação vertical : Tamanho da fonte (20) + 10
	
	public ProfileUI() {
		super("Accendo - Perfil");
		
		//Profile Img
		profileImg=new JLabel(new ImageIcon("src/img/defaultUser.png"));
		profileImg.setBounds(100,100,256,256);
		
		//Body
		jlName=new JLabel("Nome:");
		jlNameInput=new JLabel("Lucas Santos de Jesus");
		jlName.setFont(bodyFont); jlNameInput.setFont(bodyFont);
		jlName.setBounds(400,100,60,30);
		jlNameInput.setBounds(461,100,400,30);
		
		jlSexo=new JLabel("Sexo:");
		jlSexoInput=new JLabel("Outros");
		jlSexo.setFont(bodyFont); jlSexoInput.setFont(bodyFont);
		jlSexo.setBounds(400,130,50,30);
		jlSexoInput.setBounds(455,130,68,30);
		
		JLabel jlIdade=new JLabel("Idade:");
		JLabel jlIdadeInput=new JLabel("21");
		jlIdade.setFont(bodyFont); jlIdadeInput.setFont(bodyFont);
		jlIdade.setBounds(573,130,60,30);
		jlIdadeInput.setBounds(632,130,50,30);
		
		JLabel jlRG=new JLabel("RG:");
		JLabel jlRGInput=new JLabel("11.111.111-1");
		jlRG.setFont(bodyFont); jlRGInput.setFont(bodyFont);
		jlRG.setBounds(400,160,36,30);
		jlRGInput.setBounds(439,160,130,30);
		
		JLabel jlCpf=new JLabel("CPF:");
		JLabel jlCpfInput=new JLabel("111.111.111-11");
		jlCpf.setFont(bodyFont); jlCpfInput.setFont(bodyFont);
		jlCpf.setBounds(400,190,45,30);
		jlCpfInput.setBounds(450,190,140,30);
		
		JLabel jlSerie=new JLabel("Série/Ano:");
		JLabel jlSerieInput=new JLabel("9º");
		jlSerie.setFont(bodyFont); jlSerieInput.setFont(bodyFont);
		jlSerie.setBounds(400,220,92,30);
		jlSerieInput.setBounds(495,220,28,30);
		
		JLabel jlEtapa=new JLabel("Etapa:");
		JLabel jlEtapaInput=new JLabel("Fundamental");
		jlEtapa.setFont(bodyFont); jlEtapaInput.setFont(bodyFont);
		jlEtapa.setBounds(400,250,58,30);
		jlEtapaInput.setBounds(463,250,127,30);
		
		//Adicionando
		getContentPane().add(profileImg);
		
		getContentPane().add(jlName);getContentPane().add(jlNameInput);getContentPane().add(jlSexo);getContentPane().add(jlSexoInput);
		getContentPane().add(jlIdade); getContentPane().add(jlIdadeInput); getContentPane().add(jlRG); getContentPane().add(jlRGInput);
		getContentPane().add(jlCpf);getContentPane().add(jlCpfInput); getContentPane().add(jlSerie); getContentPane().add(jlSerieInput);
		getContentPane().add(jlEtapa); getContentPane().add(jlEtapaInput);
		
		//Adicionando mainMenuPanel
		mainMenuPanel=new MainMenuPanel();
		getContentPane().add(mainMenuPanel);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
}