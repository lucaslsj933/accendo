package professor.insert;

import java.util.ArrayList;

//Esta classe pega os dados da tabela que aparece ao usuário e copia os dados para o aAndNList de ProfInsertUI

import javax.swing.*;
import javax.swing.event.*;
import java.lang.NumberFormatException;

import main.Main;

public class AlunoAndNotasSyncer implements TableModelListener{
	public void tableChanged(TableModelEvent tableModelEvent) {
		try {
			//Lembre-se que todas os objetos e variáveis em java são ponteiros
			JTable tableCache=Main.profInsertUI.getTable();
			ArrayList<AlunoAndNotasQuery> aAndNListCache=Main.profInsertUI.getaAndNList();
			
			if(tableCache.isEditing()) {
				String valueString=(String)tableCache.getValueAt(tableCache.getSelectedRow(), tableCache.getSelectedColumn());
				//Se não estiver nada escrito saímos do método
				if(valueString.equals("")) 
					return;
				Float value=Float.parseFloat(valueString);
				
				aAndNListCache.get(tableCache.getSelectedRow()).setNotaByTaIndex(tableCache.getSelectedColumn()-2, value);
				
				/*
				   JOptionPane.showMessageDialog(null,"Value: "+
						aAndNListCache.get(tableCache.getSelectedRow()).getNotaByTaIndex(tableCache.getSelectedColumn()-2)
						);
				 */
			}
		}
		catch(NumberFormatException e) {
			JTable tableCache=Main.profInsertUI.getTable();
			JOptionPane.showMessageDialog(null,"Nota inválida!");
			tableCache.setValueAt("",tableCache.getSelectedRow(), tableCache.getSelectedColumn());
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO! "+e.toString());
		}
	}
}
