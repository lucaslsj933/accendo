package profile;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import mainMenu.MainMenuPanel;
import java.awt.Font;

public class ProfileUI extends JFrame{
	private Font boldBodyFont=new Font("Arial", Font.BOLD, 20); //Font.PLAIN
	private Font bodyFont=new Font("Arial", Font.PLAIN, 20); //Font.PLAIN
	
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
		jlName.setFont(boldBodyFont); jlNameInput.setFont(bodyFont);
		jlName.setBounds(400,100,68,30);
		jlNameInput.setBounds(469,100,400,30);
		
		jlSexo=new JLabel("Sexo:");
		jlSexoInput=new JLabel("Outros");
		jlSexo.setFont(boldBodyFont); jlSexoInput.setFont(bodyFont);
		jlSexo.setBounds(400,130,68,30);
		jlSexoInput.setBounds(463,130,68,30);
		
		JLabel jlIdade=new JLabel("Idade:");
		JLabel jlIdadeInput=new JLabel("21");
		jlIdade.setFont(boldBodyFont); jlIdadeInput.setFont(bodyFont);
		jlIdade.setBounds(573,130,60,30);
		jlIdadeInput.setBounds(640,130,50,30);
		
		JLabel jlRG=new JLabel("RG:");
		JLabel jlRGInput=new JLabel("11.111.111-1");
		jlRG.setFont(boldBodyFont); jlRGInput.setFont(bodyFont);
		jlRG.setBounds(400,160,45,30);
		jlRGInput.setBounds(447,160,130,30);
		
		JLabel jlCpf=new JLabel("CPF:");
		JLabel jlCpfInput=new JLabel("111.111.111-11");
		jlCpf.setFont(boldBodyFont); jlCpfInput.setFont(bodyFont);
		jlCpf.setBounds(400,190,58,30);
		jlCpfInput.setBounds(458,190,140,30);
		
		JLabel jlSerie=new JLabel("Série/Ano:");
		JLabel jlSerieInput=new JLabel("9º");
		jlSerie.setFont(boldBodyFont); jlSerieInput.setFont(bodyFont);
		jlSerie.setBounds(400,220,104,30);
		jlSerieInput.setBounds(511,220,28,30);
		
		JLabel jlEtapa=new JLabel("Etapa:");
		JLabel jlEtapaInput=new JLabel("Fundamental");
		jlEtapa.setFont(boldBodyFont); jlEtapaInput.setFont(bodyFont);
		jlEtapa.setBounds(400,250,68,30);
		jlEtapaInput.setBounds(471,250,127,30);
		
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