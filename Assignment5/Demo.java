import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		double[][]data=new double[10][10];
		File file=new File("C:\\Users\\steum\\eclipse-workspace\\dataSet1(1).txt");
		Scanner sc=new Scanner(file);
		for (int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				data=TwoDimRaggedArrayUtility.readFile(file);
			}
		}
		for (int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}	

	}

}
