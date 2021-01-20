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
	private JButton button2;
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
		
		this.button2 =new JButton("sort by lastname");
		
		this.add(button2);
		
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

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
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
	
	
	

}




	
	


