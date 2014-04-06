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
		JTextField[][] field=new JTextField[9][9];
		
		int startx=(x/2)-135;
		int starty=(y/2)-135;
		
		for(int i=0;i<9;i++){
			starty=(y/2)-135;
			for(int j=0;j<9;j++){
				field[i][j]=new JTextField();
				pan.add(field[i][j]);
				field[i][j].setBounds(startx, starty, 30, 30);
				starty+=30;
			}
			startx+=30;
		}
	
		

	}
}
