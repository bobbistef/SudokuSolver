package main;

import java.util.ArrayList;

public class Solver {
	private Grid grid=new Grid();
	
	public Solver(){
	}
	
	public void addArray(int[][]a){
		grid.addArray(a);
	}
	public Grid grid(){
		return grid;
	}
	public void solve(){
		refresh();
		onlyChoice();
		singlePossibilities();
	}
	public void refresh(){
		clean();
		findPossible();
	}
	public void clean(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid.get(i, j)!=0){
					grid.addPoss(i, j, null);	
				}
			}
		}
	}
	public void findPossible(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid.get(i, j)==0){
					grid.addPoss(i, j,findPossibleCell(i,j));	
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
	public void onlyChoice(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if((grid.get(i, j)==0)&&(grid.getPoss(i, j)).size()==1&&grid.getPoss(i, j).get(0)!=0){
					grid.addNumber(i, j, (grid.getPoss(i, j).get(0)));
				}
			}
		}
		refresh();
	}
	public void singlePossibilities(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid.get(i, j)==0){
					checkSinglePossibility(i,j);
				}
			}
		}
		refresh();
	}
	public int checkSinglePossibility(int x, int y){
		ArrayList<Integer> myPoss=grid.getPoss(x, y);
		ArrayList<Integer>found=new ArrayList<Integer>();
		//check horizontal
		
		System.out.println(x+","+y+":");
		
		
		for(int i=0;i<9;i++){
			if(grid.get(i,y)==0&&i!=x){
				ArrayList<Integer>toadd=grid.getPoss(i, y);
				for(int a:toadd){
					if(!found.contains(a)){
						found.add(a);
						
						System.out.print(a);
					}
				}
			}
		}
		System.out.println(".");
		System.out.print("FOUND:");
		for(int a:found){
			System.out.print(a);
		}
		System.out.println(".");
		System.out.print("MYPOSS:");
		for(int a:myPoss){
			System.out.print(a);
		}
		System.out.println(".");
		
//		if(x==5&&y==0){
//			System.out.print("FOUND:");
//			for(int a:found){
//				System.out.print(a);
//			}
//			System.out.println(".");
//			System.out.print("MYPOSS:");
//			for(int a:myPoss){
//				System.out.print(a);
//			}
//			System.out.println(".");
//		}
		myPoss.removeAll(found);
//		System.out.print(x+","+y+":");
//		for(int a:myPoss){
//			System.out.print(a);
//		}
//		System.out.println(";");
		if(myPoss.size()==1){
			grid.addNumber(x,y,myPoss.get(0));
			return myPoss.get(0);
		}
		
		myPoss=grid.getPoss(x, y);
		//checkvertical
		for(int i=0;i<9;i++){
			if(grid.get(x,i)==0&&i!=y){
				ArrayList<Integer>toadd=grid.getPoss(x, i);
				for(int a:toadd){
					if(!found.contains(a)){
						found.add(a);
					}
				}
			}
		}
		
		myPoss.removeAll(found);
		if(myPoss.size()==1){
			grid.addNumber(x,y,myPoss.get(0));
			return myPoss.get(0);
		}
		//checksquare
		myPoss=grid.getPoss(x, y);
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
				if(grid.get(tx,ty)==0&&i!=x&&j!=y){
					ArrayList<Integer>toadd=grid.getPoss(x, y);
					for(int a:toadd){
						if(!found.contains(a)){
							found.add(a);
						}
					}
				}
			}
		}
		myPoss.removeAll(found);
		if(myPoss.size()==1){
			grid.addNumber(x,y,myPoss.get(0));
			return myPoss.get(0);
		}
		return 0;
	}
}
