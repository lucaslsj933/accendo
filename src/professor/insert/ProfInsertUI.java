package professor.insert;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import consultar.Materia;
import main.BigTableUIMasterClass;
import main.Main;
import mainMenu.MainMenuPanel;
import professor.mainMenu.ProfMainMenuPanel;
import professor.profile.Professor;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ProfInsertUI extends BigTableUIMasterClass{
	private ProfMainMenuPanel profMainMenuPanel;
	private JLabel jlTurma,jlMateria;
	private JComboBox<String> jcbTurma,jcbMateria;
	private JButton jbLoadTurma,jbInsertNotas;
	
	//Lembre-se que idMateriaAtual só é mudada quando carregamos uma turma
	private int idMateriaAtual;
	private ArrayList<Turma> listaTurmas=new ArrayList<Turma>();
	private ArrayList<AlunoAndNotasQuery> aAndNList=new ArrayList<AlunoAndNotasQuery>();
	
	private ArrayList<MateriaAndProfQuery> mAndPList=new ArrayList<MateriaAndProfQuery>();

	private LucasNotasContainerPro lncPro=new LucasNotasContainerPro();
	private ArrayList<Materia> listaMateria=new ArrayList<Materia>();;
	private ArrayList<Professor> listaProf=new ArrayList<Professor>();;
	
	public ProfInsertUI() {
		setTitle("Accendo - Inserir Notas");
		
		//Turma Select
		
		jlTurma=new JLabel("Turma: ");
		jlTurma.setBounds(50,60,100,30);
		jlTurma.setFont(getBodyFont());
		
		jlMateria=new JLabel("Matéria: ");
		jlMateria.setBounds(440,60,100,30);
		jlMateria.setFont(getBodyFont());
		
		String dataJcbTurma[]={"Turma 1","Turma 2","Turma 3","Turma 4","Turma 5"};
		jcbTurma=new JComboBox<String>();
		jcbTurma.setBounds(120,50,300,50);
		
		String dataJcbMateria[]={"Matéria 1","Matéria 2","Matéria 3","Matéria 4","Matéria 5"};
		jcbMateria=new JComboBox<String>();
		jcbMateria.setBounds(520,50,300,50);
		
		jbLoadTurma=new JButton("Carregar Turma");
		jbLoadTurma.setBounds(850,50,350,50);
		jbLoadTurma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Lembre-se que você também tem que limpar a aAndNList!
					Main.profInsertUI.setTableToDefault();
					aAndNList.removeAll(aAndNList);

					//Settando a materia atual 
					int jcbIndex=Main.profInsertUI.getJcbMateria().getSelectedIndex();
					Main.profInsertUI.setIdMateriaAtual(
							Main.profInsertUI.getmAndPList().get(jcbIndex).getIdMateria());
					
					Main.dbMain.profInsert_AlunosLoad();
				}
		});
		
		jbInsertNotas=new JButton("Inserir Notas");
		jbInsertNotas.setBounds(900,615,350,50);
		jbInsertNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.dbMain.profInsert_InsertNotas();
			}
		});
		
		
		//Definindo tamanho, posição e inserindo dados padrão
		setTableToDefault();
		
		//Quando algo é selecionado na tabela
		/*
		getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				JOptionPane.showMessageDialog(null,"Teste");
			}
		});
		*/
		
		
		//Adicionando (além da super-classe)
		add(jlTurma);add(jlMateria);add(jcbTurma);add(jcbMateria);add(jbLoadTurma);add(jbInsertNotas);
		
		//ProfMainMenuPanel
		remove(getMainMenuPanel());
		setMainMenuPanel(null);
		profMainMenuPanel=new ProfMainMenuPanel();
		add(profMainMenuPanel);
	}
	
	public void setTableToDefault() {
		String colunas[]={"Aluno","Matrícula","TA1","TA2","TA3","TA4"};
		String data[][]=new String[30][6];
		
		
		/*
		 * Velho método de placeholders
		 * 
		 * 		for(int i=0;i<30;i++) {
					data[i][0]="Aluno "+(String.valueOf(i+1));
					data[i][1]=""; data[i][2]=""; data[i][3]=""; data[i][4]=""; data[i][5]="";
				}
		 * 
		 */
		
		//Método de placeholders
		int rowCount=getTable().getRowCount();
		int columnCount=getTable().getColumnCount();
		for(int i=0;i<rowCount;i++) {
			for(int i2=0;i2<columnCount;i2++) {
				data[i][i2]="";
			}
		}
		
		getTable().setModel(new DefaultTableModel(data, colunas));
		
		//Tamanho e posição
		getJsp().setBounds(50,120,1150,480);
		  
		TableColumn tb0=getTable().getColumnModel().getColumn(0);
		TableColumn tb1=getTable().getColumnModel().getColumn(1);
		TableColumn tb2=getTable().getColumnModel().getColumn(2);
		TableColumn tb3=getTable().getColumnModel().getColumn(3);
		TableColumn tb4=getTable().getColumnModel().getColumn(4);
		TableColumn tb5=getTable().getColumnModel().getColumn(5);
		tb0.setMaxWidth(800);
		tb1.setMaxWidth(100); tb2.setMaxWidth(100); tb3.setMaxWidth(100); tb4.setMaxWidth(100); tb5.setMaxWidth(100);
	}
	
	//Este método deve ser executado depois das turmas serem inseridas no jcbTurma!
	public void addALToJcbTurma() {
		jcbTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Removendo os items já inseridos
				jcbMateria.removeAllItems();
				mAndPList.removeAll(mAndPList);
				
				int turma_idTurma=listaTurmas.get(jcbTurma.getSelectedIndex()).getIdTurma();
				
				Main.dbMain.profInsert_MandPQueryLoadThread(turma_idTurma);
			}
		});
	}

	public ProfMainMenuPanel getProfMainMenuPanel() {
		return profMainMenuPanel;
	}

	public void setProfMainMenuPanel(ProfMainMenuPanel profMainMenuPanel) {
		this.profMainMenuPanel = profMainMenuPanel;
	}

	public JComboBox<String> getJcbTurma() {
		return jcbTurma;
	}

	public void setJcbTurma(JComboBox<String> jcbTurma) {
		this.jcbTurma = jcbTurma;
	}

	public JLabel getJlTurma() {
		return jlTurma;
	}

	public void setJlTurma(JLabel jlTurma) {
		this.jlTurma = jlTurma;
	}

	public JButton getJbLoadTurma() {
		return jbLoadTurma;
	}

	public void setJbLoadTurma(JButton jbLoadTurma) {
		this.jbLoadTurma = jbLoadTurma;
	}

	public ArrayList<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(ArrayList<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
	
	public ArrayList<AlunoAndNotasQuery> getaAndNList() {
		return aAndNList;
	}

	public void setaAndNList(ArrayList<AlunoAndNotasQuery> aAndNList) {
		this.aAndNList = aAndNList;
	}

	public JLabel getJlMateria() {
		return jlMateria;
	}

	public void setJlMateria(JLabel jlMateria) {
		this.jlMateria = jlMateria;
	}

	public JComboBox<String> getJcbMateria() {
		return jcbMateria;
	}

	public void setJcbMateria(JComboBox<String> jcbMateria) {
		this.jcbMateria = jcbMateria;
	}

	public ArrayList<MateriaAndProfQuery> getmAndPList() {
		return mAndPList;
	}

	public void setmAndPList(ArrayList<MateriaAndProfQuery> mAndPList) {
		this.mAndPList = mAndPList;
	}

	public JButton getJbInsertNotas() {
		return jbInsertNotas;
	}

	public void setJbInsertNotas(JButton jbInsertNotas) {
		this.jbInsertNotas = jbInsertNotas;
	}

	public int getIdMateriaAtual() {
		return idMateriaAtual;
	}

	public void setIdMateriaAtual(int idMateriaAtual) {
		this.idMateriaAtual = idMateriaAtual;
	}

	public ArrayList<Materia> getListaMateria() {
		return listaMateria;
	}

	public void setListaMateria(ArrayList<Materia> listaMateria) {
		this.listaMateria = listaMateria;
	}

	public ArrayList<Professor> getListaProf() {
		return listaProf;
	}

	public void setListaProf(ArrayList<Professor> listaProf) {
		this.listaProf = listaProf;
	}
}