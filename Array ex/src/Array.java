
public class Array {
	public static int[] getEvenArray(int[] numbers)  {
		int size = 0;

		for(int i = 0; i < numbers.length; i++)
			if(numbers[i]%2 == 0)
				size++;

		int[] evenArray = new int[size];

		int evenArrayIndex = 0;

		for(int i = 0; i < numbers.length; i++)  {
			if(numbers[i]%2 == 0)  {
				evenArray[evenArrayIndex] = numbers[i];
				evenArrayIndex++;
			}		
		}
		return evenArray;
	}

	public static void main(String[] args) {
		int[] ar= {1,2,3,4,5,6,7,8,9,10};
		for (int i=0;i<getEvenArray(ar).length;i++) {
			System.out.print(getEvenArray(ar)[i]+" ");
		}
	}

}
