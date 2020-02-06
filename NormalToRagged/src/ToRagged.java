import java.util.ArrayList;

public class ToRagged {

	public static void main(String[] args) {
		int[][]ar= {{1,0,0},
					{1,0,1},
					{0,0,1}};
		int [][] ar1=new int[ar.length][];
		ArrayList<Integer> index=new ArrayList<Integer>();
		int count=0;
		for(int i=0;i<ar.length;i++) {
			for(int j=0; j<ar[i].length;j++) {
				if(ar[i][j]!=0) {
				count++;
				index.add(j);
			}
		}
			ar1[i] =new int[count];
			count=0;
		}
		for(int i=0;i<ar1.length;i++) {
			for(int j=0; j<ar1[i].length;j++) {
				ar1[i][j]=ar[i][index.get(i)];
			
		}
		}	
		for(int i=0;i<ar1.length;i++) {
		for(int j=0; j<ar1[i].length;j++) {
			System.out.print(ar1[i][j]);
		}
		System.out.println();
		}

	}
}
