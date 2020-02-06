
public class ToRagged2 {
	public static void main(String[] args) {
		int[][] ar= {{1,2,3},
					 {1,0,0},
					 {1,2,0}
		};
		int [][]ar1=new int[ar.length][];
		int col=0;
		for(int r=0;r<ar.length;r++) {
			col=0;
			for(int c=0;c<ar[r].length;c++) {
				if(ar[r][c]!=0) {
					col++;
				}
			}
			ar1[r]=new int[col];
			for(int c=0;c<ar[r].length;c++) {
				if(ar[r][c]!=0) {
					ar1[r][c]=ar[r][c];
				}
			}
		}
		for(int i=0;i<ar1.length;i++) {
			for(int j=0;j<ar1[i].length;j++) {
				System.out.print(ar1[i][j]+" ");
			}
			System.out.println();
		}
						 
	}
}
