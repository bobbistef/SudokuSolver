package main;

import java.util.ArrayList;

public class Grid {
	int[][]nums;
	ArrayList<Integer>[][]poss=new ArrayList[9][9];
	boolean[][]changed=new boolean[9][9];
	public Grid(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				changed[i][j]=false;
			}
		}
	}
	public void addArray(int[][]a){
		nums=a;
	}
	public void addNumber(int x, int y, int n){
		nums[x][y]=n;
		changed[x][y]=true;
	}
	public void addPoss(int x, int y,ArrayList<Integer> a){
		poss[x][y]=a;
	}
	
	public int get(int x,int y){
		if(nums[x][y]>0&&nums[x][y]<10){
			return nums[x][y];
		}
		//return 0 if there's no number in grid yet
		return 0;
	}
	public ArrayList<Integer> getPoss(int x, int y){
		if(poss[x][y]!=null){
			return poss[x][y];
		}
		return null;
	}
	public boolean changed(int x,int y){
		if(changed[x][y]==true){
			changed[x][y]=false;
			return true;
		}
		return false;
	}
}
