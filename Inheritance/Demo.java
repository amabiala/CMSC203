
public class Demo {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Mary");
		p.setAge(20);
		
		
		Student s = new Student();
		s.setName("Bob");
		s.setAge(21);
		s.setStudentId(1234);
		
		Student s1 = new Student("John",23,2433); 
		
		System.out.println(s1.getName()+" is "+s1.getAge()+" years old");
		System.out.println(s1.getStudentId());
		System.out.println(p.getName()+" is "+p.getAge()+" years old");
		System.out.println(s.getName()+" is "+s.getAge()+" years old");
		System.out.println(s.getStudentId());
	}

}
