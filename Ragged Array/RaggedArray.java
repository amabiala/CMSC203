import java.util.ArrayList;
import java.util.Scanner;
public class RaggedArray {

	public static void main(String[] args) {
		int[][] ar= new int [3][];
		ar[0]=new int[2];
		ar[1]=new int[4];
		ar[2]=new int[1];
		int small;
		
		ArrayList<Integer> ar1=new ArrayList<Integer>(ar.length);
		ar[0][0]=9;
		ar[0][1]=12;
		ar[1][0]=6;
		ar[1][1]=1;
		ar[1][2]=5;
		ar[1][3]=4;
		ar[2][0]=2;
		small=ar[0][0];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				if(small>ar[i][j]) {
					small=ar[i][j];
			}
		}
		}
		System.out.println("smallest:"+small);
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				ar1.add(ar[i][j]);
			}
			}
		for(int i=0;i<ar1.size();i++) {
			System.out.print(ar1.get(i)+" ");
			
		}
		System.out.println();
	}
	public static int[][] createRaggedArray(){
		Scanner sc=new Scanner(System.in);
		int[][]	ar2 = null;
		int columns=0;
		int rows=0;
	    System.out.print("Please enter the number of rows for your array: ");
		rows= sc.nextInt();
		for(int i=0;i<ar2.length;i++) {
		System.out.print("Please enter the number of columns for row: "+ i+1);
		columns= sc.nextInt();
		}
		ar2=new int[rows][columns];
		for(int i=0;i<ar2.length;i++) {
			for(int j=0;j<ar2[i].length;j++) {
				System.out.print("Please enter the "+ j+1+" element for row "+i+1+ ": ");
				ar2[i][j]=sc.nextInt();
			}
	}
		return ar2;
	}
}
