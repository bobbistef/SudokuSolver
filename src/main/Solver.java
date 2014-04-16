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
		//checkvert
		ArrayList<Integer>myposs=grid.getPoss(x, y);
		ArrayList<Integer>foundposs=new ArrayList<Integer>();
		for(int i=0;i<9;i++){
			if(i!=x&&grid.get(i, y)==0){
				ArrayList<Integer>temp=grid.getPoss(i, y);
				for(int a:temp){
					if(!foundposs.contains(a)){
						foundposs.add(a);
					}
				}
			}
		}
		ArrayList<Integer>np=new ArrayList<Integer>();
		for(int i:myposs){
			boolean found=false;
			for(int b:foundposs){
				if(i==b){
					found=true;
				}
			}
			if(found==false){
				np.add(i);
			}
		}
		myposs=np;
		if(myposs.size()==1){
			grid.addNumber(x, y, myposs.get(0));
			return 0;
		}
		//check horiz
		myposs=grid.getPoss(x, y);
		foundposs.clear();
		for(int i=0;i<9;i++){
			if(i!=y&&grid.get(x, i)==0){
				ArrayList<Integer>temp=grid.getPoss(x, i);
				for(int a:temp){
					if(!foundposs.contains(a)){
						foundposs.add(a);
					}
				}
			}
		}
		np.clear();
		for(int i:myposs){
			boolean found=false;
			for(int b:foundposs){
				if(i==b){
					found=true;
				}
			}
			if(found==false){				
				np.add(i);
			}
		}
		myposs=np;
		if(myposs.size()==1){
			grid.addNumber(x, y, myposs.get(0));
			return 0;
		}
		//checksquare
		myposs=grid.getPoss(x, y);
		foundposs.clear();
		np.clear();
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
				if(tx!=x&&ty!=y&&grid.get(tx,ty)==0){
					ArrayList<Integer>temp=grid.getPoss(tx, ty);
					for(int a:temp){
						if(!foundposs.contains(a)){
							foundposs.add(a);
						}
					}
				}
			}
		}
		for(int i:myposs){
			boolean found=false;
			for(int b:foundposs){
				if(i==b){
					found=true;
				}
			}
			if(found==false){				
				np.add(i);
			}
		}
		myposs=np;
		if(myposs.size()==1){
			grid.addNumber(x, y, myposs.get(0));
			return 0;
		}
		return 0;
	}
}
