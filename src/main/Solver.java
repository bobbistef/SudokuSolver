package main;

import java.util.ArrayList;

public class Solver {
	Grid grid=new Grid();
	public Solver(){
	}
	
	public void addArray(int[][]a){
		grid.addArray(a);
	}
	public void solve(){
		findPossible();
		singlePossibilities();
	}
	public void findPossible(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid.get(i, j)==0){
					grid.addPoss(i, j,findPossibleCell(i,j));	
				}
				else{
					grid.addPoss(i, j, null);
				}
			}
		}
	}
	public ArrayList<Integer> findPossibleCell(int x,int y){
		ArrayList <Integer>found=new ArrayList<Integer>();
		ArrayList<Integer>poss=new ArrayList<Integer>();
		for(int i=1;i<10;i++){
			poss.add(i);
		}
		for(int i=0;i<9;i++){
			if(grid.get(i,y)!=0){
				if(!found.contains(grid.get(i,y))){
					found.add(grid.get(i,y));
				}
			}
		}
		for(int i=0;i<9;i++){
			if(grid.get(x,i)!=0){
				if(!found.contains(grid.get(x,i))){
					found.add(grid.get(x,i));
				}
			}
		}
		int grx=0;
		int gry=0;
		if(x<3){
			grx=0;
		}
		else if(x<6){
			grx=3;
		}
		else{
			grx=6;
		}
		if(y<3){
			gry=0;
		}
		else if(y<6){
			gry=3;
		}
		else{
			gry=6;
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int tx=grx+i;
				int ty=gry+j;
				if(grid.get(tx,ty)!=0){
					if(!found.contains(grid.get(tx,ty))){
						found.add(grid.get(tx,ty));
					}
				}
				
			}
		}
		poss.removeAll(found);
		return poss;
	}
	public void singlePossibilities(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if((grid.get(i, j)==0)&&(grid.getPoss(i, j)).size()==1&&grid.getPoss(i, j).get(0)!=0){
					grid.addNumber(i, j, (grid.getPoss(i, j).get(0)));
				}
			}
		}
	}
	public Grid grid(){
		return grid;
	}
}
