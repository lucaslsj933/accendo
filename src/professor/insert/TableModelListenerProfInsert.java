package professor.insert;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import main.Main;

public class TableModelListenerProfInsert implements TableModelListener{
	public void tableChanged(TableModelEvent e) {
		int row=e.getFirstRow();
		int column=e.getColumn();
		
		System.out.println("Change! Item: "+
				Main.profInsertUI.getTable().getModel().getValueAt(row,column));
	}
}
