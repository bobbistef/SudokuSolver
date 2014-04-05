package main;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	JFrame f;
	JPanel pan;
	Toolkit tk = Toolkit.getDefaultToolkit();  
	int x = ((int) tk.getScreenSize().getWidth());  
	int y = ((int) tk.getScreenSize().getHeight());  
	
	public static void main(String[] args) {
		new Driver().start();
	}
	public void start(){
		createFrame();
	}
	public void createFrame(){
		f=new JFrame("Sudoku Solver");
		pan=new JPanel();
		createGrid();
		f.add(pan);
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setVisible(true);
	}
	public void createGrid(){
		pan.setBounds(f.getBounds());
		pan.setLayout(null);
		JTextField t11=new JTextField();
		JTextField t12=new JTextField();
		JTextField t13=new JTextField();
		JTextField t14=new JTextField();
		JTextField t15=new JTextField();
		JTextField t16=new JTextField();
		JTextField t17=new JTextField();
		JTextField t18=new JTextField();
		JTextField t19=new JTextField();
		
		JTextField t21=new JTextField();
		JTextField t22=new JTextField();
		JTextField t23=new JTextField();
		JTextField t24=new JTextField();
		JTextField t25=new JTextField();
		JTextField t26=new JTextField();
		JTextField t27=new JTextField();
		JTextField t28=new JTextField();
		JTextField t29=new JTextField();
		
		JTextField t31=new JTextField();
		JTextField t32=new JTextField();
		JTextField t33=new JTextField();
		JTextField t34=new JTextField();
		JTextField t35=new JTextField();
		JTextField t36=new JTextField();
		JTextField t37=new JTextField();
		JTextField t38=new JTextField();
		JTextField t39=new JTextField();
		
		JTextField t41=new JTextField();
		JTextField t42=new JTextField();
		JTextField t43=new JTextField();
		JTextField t44=new JTextField();
		JTextField t45=new JTextField();
		JTextField t46=new JTextField();
		JTextField t47=new JTextField();
		JTextField t48=new JTextField();
		JTextField t49=new JTextField();
		
		JTextField t51=new JTextField();
		JTextField t52=new JTextField();
		JTextField t53=new JTextField();
		JTextField t54=new JTextField();
		JTextField t55=new JTextField();
		JTextField t56=new JTextField();
		JTextField t57=new JTextField();
		JTextField t58=new JTextField();
		JTextField t59=new JTextField();
		
		int startx=(x/2)-90;
		int starty=(y/2)-90;
		
	}
}
