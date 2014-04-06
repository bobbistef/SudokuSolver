package main;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.FieldPosition;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	JFrame f;
	JPanel pan;
	Toolkit tk = Toolkit.getDefaultToolkit();  
	int x = ((int) tk.getScreenSize().getWidth());  
	int y = ((int) tk.getScreenSize().getHeight()); 
	JTextField[][] field=new JTextField[9][9];
	int[][]nums=new int[9][9];
	Solver so=new Solver();
	
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
		
		int startx=(x/2)-140;
		int starty=(y/2)-140;
		
		for(int i=0;i<9;i++){
			startx=(x/2)-140;
			for(int j=0;j<9;j++){
				field[i][j]=new JTextField();
				pan.add(field[i][j]);
				field[i][j].setBounds(startx, starty, 30, 30);
				startx+=30;
				if(j==2||j==5){
					startx+=5;
				}
			}
			starty+=30;
			if(i==2||i==5){
				starty+=5;
			}
		}
		
		final JButton b=new JButton("Start");
		pan.add(b);
		b.setBounds((x/2)-50, starty+20, 100, 30);
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<9;i++){
					for(int k=0;k<9;k++){
						String s=field[i][k].getText();
						if(!s.equals("")){
							nums[i][k]=Integer.parseInt(s);
						}
					}
				}
				so.addArray(nums);
				work();
			}
			
		});
		
	}
	public void work(){
		so.solve();
		for(int i=0;i<9;i++){
			for(int k=0;k<9;k++){
				if(so.grid().get(i, k)!=0){
					field[i][k].setText(Integer.toString(so.grid().get(i, k)));
				}
			}
		}
		pan.repaint();
	}
}
