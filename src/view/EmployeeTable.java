package view;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeeTable extends JScrollPane{
	
	String[] columnNames;
	String[][] rowData ;	
	

	public EmployeeTable(String[][] rowData, String[] columnNames) {
		
		this.columnNames = columnNames;
		this.rowData = rowData;
		
		
		JTable jTabel = new JTable(rowData, columnNames);
		
		//Scrollbar definieren
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Positionieren
		setPreferredSize(new Dimension(400, 100));
		
		//Die Tabelle den Scrollpane zuweisen:
		setViewportView(jTabel);
				
	}


	public String[] getColumnNames() {
		return columnNames;
	}


	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}


	public String[][] getRowData() {
		return rowData;
	}


	public void setRowData(String[][] rowData) {
		this.rowData = rowData;
	}

	

}
