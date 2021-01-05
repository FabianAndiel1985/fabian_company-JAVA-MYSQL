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
	private JButton button1;
	private JButton button2;
	
	public UI() {
		
		this.setVisible(true);
		this.setTitle("Employee admin program");
		this.setSize(300,400);
		this.setLayout(new FlowLayout());
		
		this.label1 = new JLabel("Choose your action");
		this.add(label1);
		
		
		this.button1 =new JButton("show employees");
		
		this.add(button1);
		
		this.button2 =new JButton("sort employees");
		
		this.add(button2);
		
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

}




	
	


