
public class Course {
	private String name;
	
	public Course(String name) {
		this.name=name;
	}
	public Course(Course c) {
		this.name=c.name;
	}
	public void setName(String n) {
		name=n;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;	
	}
}
