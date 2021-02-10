package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UI extends JFrame {
	
//	Box Layout mit Einzelnen Containern die ein Flow Layout haben
	
	private JLabel label1;
	private JLabel label2;
	private JButton showEmployeesBtn;
	private JButton sortEmployeesByLastNameBtn;
	private JButton sortEmployeesBySalaryBtn;
	private JButton writeEmployeesToFile;
	private JButton readEmployeesFromFile;
	private EmployeeTable employeeTable;
	
	public UI() {
		
		this.setVisible(true);
		this.setTitle("Employee admin program");
		this.setSize(300,400);
		this.setLayout(new FlowLayout());
		
		this.label1 = new JLabel("Choose your action");
		this.add(label1);
		
		
		this.showEmployeesBtn =new JButton("show all employees");
		
		this.add(showEmployeesBtn);
		
		this.sortEmployeesByLastNameBtn =new JButton("sort by lastname");
		
		this.add(sortEmployeesByLastNameBtn);
		
		this.sortEmployeesBySalaryBtn =new JButton("sort by salary");
		
		this.add(sortEmployeesBySalaryBtn);
		
		this.writeEmployeesToFile = new JButton("save sorted employees");
		
		this.add(writeEmployeesToFile);
		
		this.readEmployeesFromFile = new JButton("load sorted employees");
		
		this.add(this.readEmployeesFromFile);
	}

	public JButton getReadEmployeesFromFile() {
		return readEmployeesFromFile;
	}

	public void setReadEmployeesFromFile(JButton readEmployeesFromFile) {
		this.readEmployeesFromFile = readEmployeesFromFile;
	}

	public JButton getSortEmployeesBySalaryBtn() {
		return sortEmployeesBySalaryBtn;
	}

	public void setSortEmployeesBySalaryBtn(JButton sortEmployeesBySalaryBtn) {
		this.sortEmployeesBySalaryBtn = sortEmployeesBySalaryBtn;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JButton getShowEmployeesBtn() {
		return showEmployeesBtn;
	}

	public void setShowEmployeesBtn(JButton button1) {
		this.showEmployeesBtn = button1;
	}

	public JButton getWriteEmployeesToFile() {
		return writeEmployeesToFile;
	}

	public void setWriteEmployeesToFile(JButton writeEmployeesToFile) {
		this.writeEmployeesToFile = writeEmployeesToFile;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public EmployeeTable getEmployeeTable() {
		return employeeTable;
	}

	public void setEmployeeTable(EmployeeTable employeeTable) {
		this.employeeTable = employeeTable;
	}

	public JButton getSortEmployeesByLastNameBtn() {
		return sortEmployeesByLastNameBtn;
	}

	public void setSortEmployeesByLastNameBtn(JButton sortEmployeesByLastNameBtn) {
		this.sortEmployeesByLastNameBtn = sortEmployeesByLastNameBtn;
	}

}




	
	


