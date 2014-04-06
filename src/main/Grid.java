package main;

import java.util.ArrayList;

public class Grid {
	int[][]nums;
	ArrayList<Integer>[][]poss=new ArrayList[9][9];
	public Grid(){
		
	}
	public void addArray(int[][]a){
		nums=a;
	}
	public void addNumber(int x, int y, int n){
		nums[x][y]=n;
	}
	public void addPoss(int x, int y,ArrayList<Integer> a){
		poss[x][y]=a;
	}
	
	public int get(int x,int y){
		if(nums[x][y]>0&&nums[x][y]<10){
			return nums[x][y];
		}
		return 0;
	}
	public ArrayList<Integer> getPoss(int x, int y){
		if(poss[x][y]!=null){
			return poss[x][y];
		}
		return null;
	}
}
