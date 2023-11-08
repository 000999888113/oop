package helpz;

import java.util.ArrayList;

public class Utilz {

	
	public static int[][] ArrayListTo2D(ArrayList<Integer> list,int ySize ,int xSize){
		int[][] newArr = new int[ySize][xSize];
		for(int j=0;j<newArr.length;j++) {
			for(int i=0;i<newArr[j].length;i++) {
				int index = j*ySize+i;
				newArr[j][i] = list.get(index);
			}
		}
		return newArr;
	}
	
	public static int[] Arr2DTo1D(int[][] twoArr){
		int[] newArr = new int[twoArr.length*twoArr[0].length];
		
		for(int j=0;j<twoArr.length;j++) {
			for(int i=0;i<twoArr[j].length;i++) {
				int index = j*twoArr.length+i;
				newArr[index] = twoArr[j][i];
			}
		}
		return newArr;
	}
}
