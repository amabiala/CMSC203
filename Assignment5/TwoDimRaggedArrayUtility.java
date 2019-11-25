import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	/**
	 * Reads from a file and returns a ragged array
	 * @param file file to read from
	 * @return a ragged array of doubles
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {

		int column = 0;
        String[] temp = new String[10];
        int row = 0;
        String[][] ragged = new String[10][10];
        Scanner input;
        
        ArrayList<Integer> columns = new ArrayList<Integer>();
        double[][] data;
        
        try {
            input = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }

        while (input.hasNextLine()) {
            temp = input.nextLine().trim().split(" ");

            for (column = 0; column < temp.length; column++) {

                ragged[row][column] = temp[column];
            }
            columns.add(column);
            row++;
        }

        
        data = new double[row][];

       
        double[][] dataCopy = new double[row][Collections.max(columns)];

        for (row = 0; row < columns.size(); row++) {

            int num = columns.get(row);
            data[row] = new double[columns.get(row)];

            for (column = 0; column < num; column++) {
                dataCopy[row][column] = Double.parseDouble(ragged[row][column]);

                if (dataCopy[row][column] != 0.0) {

                    data[row][column] = Double.parseDouble(ragged[row][column]);
                } else {
                    continue;
                }
            }
        }

        input.close();
        return data;
    }
		
	/**
	 * writes ragged array of doubles to a file	
	 * @param data ragged array of doubles
	 * @param outputFile file to write to
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException{
		PrintWriter write;
		try {
		write=new PrintWriter (outputFile);
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				write.print(data[i][j]+" ");
			}
			write.println();
		}
		write.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't find your file");
			System.exit(0);
		}
		
	}
	/**
	 * calculates the total of all elements in the array
	 * @param data ragged array of doubles
	 * @return sum of all elements in the array
	 */
	public static double getTotal(double[][] data) {
		double sum=0;
		for(int i=0; i<data.length;i++) {
			for(int j=0; j<data[i].length;j++) {
				sum+=data[i][j];
			}
		}
		return sum;
	}
	/**
	 * calculates the average of all elements in the array
	 * @param data ragged array of doubles
	 * @return average of all elements in the array
	 */
	public static double getAverage(double [][] data) {
		double sum=0,average;
		int count=0;
		for(int i=0; i<data.length;i++) {
			for(int j=0; j<data[i].length;j++) {
				sum+=data[i][j];
				count++;
			}
		}
		average=sum/count;
		return average;
	}
	/**
	 * calculates the total of elements in a specific row
	 * @param data ragged array of doubles
	 * @param row index to take total of
	 * @return sum of elements in a row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double sum=0;
		for(int j=0; j<data[row].length;j++) {
			sum+=data[row][j];
			
			}
		
		return sum;
	}
	/**
	 * calculates the total of elements in a specific column
	 * @param data ragged array of doubles
	 * @param col index to take total of
	 * @return  sum of elements in a column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double sum=0;
		for(int i=0; i<data.length;i++) {
			
			if(data[i].length>col) {
				sum+=data[i][col];	
			}
		}
		return sum;
	}
	/**
	 * finds the highest element in a row
	 * @param data ragged array of doubles
	 * @param row index in which to find the highest element
	 * @return highest in a row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest=data[row][0];
		
			for(int j=1; j<data[row].length;j++) {
				if(data[row][j]>highest) {
					highest=data[row][j];
				}
			}
		
		return highest;
	}
	/**
	 * finds index of the highest element in a row
	 * @param data ragged array of doubles
	 * @param row index in which to find the highest element
	 * @return index of highest element in a row
	 */
	public static double getHighestInRowIndex(double[][] data, int row) {
		double highest=data[row][0];
		int index=0;
		
			for(int j=1; j<data[row].length;j++) {
				if(data[row][j]>highest) {
					index=j;		
				}
		}
		return index;
	}
	/**
	 * finds the lowest element in a row
	 * @param data ragged array of doubles
	 * @param row index in which to find the lowest element
	 * @return lowest in a row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest=data[row][0];
		
		
			for(int j=1; j<data[row].length;j++) {
				if(data[row][j]<lowest) {
					lowest=data[row][j];		
				}
		}
		return lowest;
	}
	/**
	 * finds the index of the lowest element in a row
	 * @param data ragged array of doubles
	 * @param row index in which to find the lowest element
	 * @return index of lowest element in a row
	 */
	public static double getLowestInRowIndex(double [][] data, int row) {
		double lowest=data[row][0];
		int index=0;
		
			for(int j=0; j<data[row].length;j++) {
				if(data[row][j]<lowest) {
					lowest=data[row][j];
					index=j;		
				}
		}
		return index;
		
	}
	/**
	 * finds the highest element in a column
	 * @param data ragged array of doubles
	 * @param col index in which to find the highest element
	 * @return index of highest element in a column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0.0;
		int index = 0;

		for (int i = 0; i < data.length; i++) {
			if (col>=data[i].length) {
				continue;
			}
			else {
				if (highest < data[i][col]) {
					highest = data[i][col];
					
				}

			} 
		}

		return highest;
	}
	/**
	 * finds the index of the highest element in a column
	 * @param data ragged array of doubles
	 * @param col index in which to find the highest element
	 * @return index of highest element in a column
	 */
	public static double getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0.0;
		int index = 0;

		for (int i = 0; i < data.length; i++) {
			if (col>=data[i].length) {
				continue;
			}
			else {
				if (highest < data[i][col]) {
					highest = data[i][col];
					index = i;
				}

			} 
		}

		return index;

	}
	/**
	 * finds the lowest element in a column
	 * @param data ragged array of doubles
	 * @param col index in which to find the lowest element
	 * @return lowest element in a column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest=0;
		ArrayList<Double> ar=new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			if (col<data[i].length) {
				ar.add(data[i][col]);
			}
		}
		lowest=ar.get(0);
		for(int i=0;i<ar.size();i++) {
			if(lowest>=ar.get(i)) {
				lowest=ar.get(i);
			}
		}
		return lowest;

	}
	/**
	 * finds the index of the lowest element in a column
	 * @param data ragged array of doubles
	 * @param col index in which to find the lowest element
	 * @return index of lowest element in a column
	 */
	public static double getLowestInColumnIndex(double [][] data, int col) {
		double lowest=0;
		int index=0;
		ArrayList<String> index1=new ArrayList<String>();
		ArrayList<Double> ar=new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			if (col<data[i].length) {
				ar.add(data[i][col]);
				index1.add(Integer.toString(i));
				
			}
		}
		lowest=ar.get(0);
		for(int i=0;i<ar.size();i++) {
			if(lowest>=ar.get(i)) {
				lowest=ar.get(i);
				index=Integer.parseInt(index1.get(i));
			}
		}
		return index;
	}
	/**
	 * finds the highest element in an array
	 * @param data ragged array of doubles
	 * @return highest element in an array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest;
		double[] ar=new double[data.length];
		for(int i=0;i<data.length;i++) {
			ar[i]=getHighestInRow(data,i);
		}
		highest=ar[0];
		for(int i=1;i<data.length;i++) {
			if(highest<ar[i]) {
				highest=ar[i];
			}
		}
		return highest;
	}
	/**
	 * finds the lowest element in an array
	 * @param data ragged array of doubles
	 * @return lowest element in an array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest;
		double[] ar=new double[data.length];
		for(int i=0;i<data.length;i++) {
			ar[i]=getLowestInRow(data,i);
			
		}
		lowest=ar[0];
		for(int i=1;i<data.length;i++) {
			if(lowest>ar[i]) {
				lowest=ar[i];
			}
		}
		return lowest;
	}
}
