import java.util.Scanner;
public class Loop {

	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		int n;
		System.out.println("Enter a number: ");
		n=in.nextInt();
		while(n!=0) {
			System.out.println("Enter a number: ");
			n=in.nextInt();
			if(n==0) {
				System.out.println("Exit!");
				break;
			}
		}

	}

}
