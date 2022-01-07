package profile;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import dbTools.DBMain;
import mainMenu.MainMenuPanel;
import java.awt.Font;


public class ProfileUI extends JFrame{
	private Font boldBodyFont=new Font("Arial", Font.BOLD, 20); //Font.PLAIN
	private Font bodyFont=new Font("Arial", Font.PLAIN, 20); //Font.PLAIN
	
	private MainMenuPanel mainMenuPanel;
	private JLabel profileImg,jlName,jlNameInput,jlSexo,jlSexoInput,jlIdade,jlIdadeInput,jlRG,jlRGInput,jlCpf,jlCpfInput,jlSerie,
		jlSerieInput,jlEtapa,jlEtapaInput;
	
	//Lembre-se que o jlInput fica 5 pixels depois da label não-input
	//Separação vertical : Tamanho da fonte (20) + 10
	
	public ProfileUI() {
		super("Accendo - Perfil");
		
		//Profile Img
		profileImg=new JLabel(new ImageIcon("src/img/defaultUser.png"));
		profileImg.setBounds(100,100,256,256);
		
		//Body
		jlName=new JLabel("Nome:");
		jlNameInput=new JLabel("");
		jlName.setFont(boldBodyFont); jlNameInput.setFont(bodyFont);
		jlName.setBounds(400,100,68,30);
		jlNameInput.setBounds(469,100,400,30);
		
		jlSexo=new JLabel("Sexo:");
		jlSexoInput=new JLabel("");
		jlSexo.setFont(boldBodyFont); jlSexoInput.setFont(bodyFont);
		jlSexo.setBounds(400,130,68,30);
		jlSexoInput.setBounds(463,130,68,30);
		
		jlIdade=new JLabel("Idade:");
		jlIdadeInput=new JLabel("");
		jlIdade.setFont(boldBodyFont); jlIdadeInput.setFont(bodyFont);
		jlIdade.setBounds(573,130,60,30);
		jlIdadeInput.setBounds(640,130,50,30);
		
		jlRG=new JLabel("RG:");
		jlRGInput=new JLabel("");
		jlRG.setFont(boldBodyFont); jlRGInput.setFont(bodyFont);
		jlRG.setBounds(400,160,45,30);
		jlRGInput.setBounds(447,160,130,30);
		
		jlCpf=new JLabel("CPF:");
		jlCpfInput=new JLabel("");
		jlCpf.setFont(boldBodyFont); jlCpfInput.setFont(bodyFont);
		jlCpf.setBounds(400,190,58,30);
		jlCpfInput.setBounds(458,190,140,30);
		
		jlSerie=new JLabel("Série/Ano:");
		jlSerieInput=new JLabel("");
		jlSerie.setFont(boldBodyFont); jlSerieInput.setFont(bodyFont);
		jlSerie.setBounds(400,220,104,30);
		jlSerieInput.setBounds(511,220,28,30);
		
		jlEtapa=new JLabel("Etapa:");
		jlEtapaInput=new JLabel("");
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

	public Font getBoldBodyFont() {
		return boldBodyFont;
	}

	public void setBoldBodyFont(Font boldBodyFont) {
		this.boldBodyFont = boldBodyFont;
	}

	public Font getBodyFont() {
		return bodyFont;
	}

	public void setBodyFont(Font bodyFont) {
		this.bodyFont = bodyFont;
	}

	public MainMenuPanel getMainMenuPanel() {
		return mainMenuPanel;
	}

	public void setMainMenuPanel(MainMenuPanel mainMenuPanel) {
		this.mainMenuPanel = mainMenuPanel;
	}

	public JLabel getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(JLabel profileImg) {
		this.profileImg = profileImg;
	}

	public JLabel getJlName() {
		return jlName;
	}

	public void setJlName(JLabel jlName) {
		this.jlName = jlName;
	}

	public JLabel getJlNameInput() {
		return jlNameInput;
	}

	public void setJlNameInput(JLabel jlNameInput) {
		this.jlNameInput = jlNameInput;
	}

	public JLabel getJlSexo() {
		return jlSexo;
	}

	public void setJlSexo(JLabel jlSexo) {
		this.jlSexo = jlSexo;
	}

	public JLabel getJlSexoInput() {
		return jlSexoInput;
	}

	public void setJlSexoInput(JLabel jlSexoInput) {
		this.jlSexoInput = jlSexoInput;
	}

	public JLabel getJlIdade() {
		return jlIdade;
	}

	public void setJlIdade(JLabel jlIdade) {
		this.jlIdade = jlIdade;
	}

	public JLabel getJlIdadeInput() {
		return jlIdadeInput;
	}

	public void setJlIdadeInput(JLabel jlIdadeInput) {
		this.jlIdadeInput = jlIdadeInput;
	}

	public JLabel getJlRG() {
		return jlRG;
	}

	public void setJlRG(JLabel jlRG) {
		this.jlRG = jlRG;
	}

	public JLabel getJlRGInput() {
		return jlRGInput;
	}

	public void setJlRGInput(JLabel jlRGInput) {
		this.jlRGInput = jlRGInput;
	}

	public JLabel getJlCpf() {
		return jlCpf;
	}

	public void setJlCpf(JLabel jlCpf) {
		this.jlCpf = jlCpf;
	}

	public JLabel getJlCpfInput() {
		return jlCpfInput;
	}

	public void setJlCpfInput(JLabel jlCpfInput) {
		this.jlCpfInput = jlCpfInput;
	}

	public JLabel getJlSerie() {
		return jlSerie;
	}

	public void setJlSerie(JLabel jlSerie) {
		this.jlSerie = jlSerie;
	}

	public JLabel getJlSerieInput() {
		return jlSerieInput;
	}

	public void setJlSerieInput(JLabel jlSerieInput) {
		this.jlSerieInput = jlSerieInput;
	}

	public JLabel getJlEtapa() {
		return jlEtapa;
	}

	public void setJlEtapa(JLabel jlEtapa) {
		this.jlEtapa = jlEtapa;
	}

	public JLabel getJlEtapaInput() {
		return jlEtapaInput;
	}

	public void setJlEtapaInput(JLabel jlEtapaInput) {
		this.jlEtapaInput = jlEtapaInput;
	}
}