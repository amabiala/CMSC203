
public class Student extends Person {
	private int studentId;
	
	public Student() {
		super();
		studentId=0;
		
	}
	public Student (String name, int age, int studentId) {
		super(name,age);
		this.studentId=studentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
