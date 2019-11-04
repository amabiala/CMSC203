
public class StudentDemo {

	public static void main(String[] args) {
		Student s1= new Student("Mary","CMSC 203");
		Course c1=new Course ("CMSC140");
		Course c2=new Course (c1);
		Student s2= new Student("Jean", "CMSC140");
		Course c=new Course(s2.getCourse());
		c.setName("wrong course");
		
		System.out.println(s1);
		System.out.println(s2);

	}

}
