import java.util.Scanner;
public class BookDemo {
	private static Scanner sc=new Scanner(System.in);
	public static void  show(Book b) {
		System.out.println("Cheapest Book:\n"+"Title: "+b.getTitle()+"\nAuthor: "+b.getAuthor()+"\nPrice: "+b.getPrice());
	}
	
	public static Book findCheapest(Book[]arr) {
		Book cheapBook;
		cheapBook=arr[0];
		for(int i=1;i<arr.length;i++) {
			if (arr[i].getPrice()<cheapBook.getPrice()) {
				cheapBook=arr[i];
			}
		}
		return cheapBook;
	}
	public static void initArr(Book[] arr){
		for(int i=0; i <arr.length; i++){
			
			System.out.print("Enter ["+i+"] title: ");
			String title = sc.nextLine();
			System.out.print("Enter ["+i+"] author: ");
			String author = sc.nextLine();
			System.out.print("Enter ["+i+"] price: ");
			Double price = sc.nextDouble();
			sc.nextLine();
			
			arr[i] = new Book(title, author, price);
		}
	}

	
	public static void main(String[] args) {
		Book[] ar=new Book[3];
		initArr(ar);
		findCheapest(ar);
		show(findCheapest(ar));
	}

}
