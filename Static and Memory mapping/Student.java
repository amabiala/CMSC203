
public class Student {
	private String name;
	private Course course;
	public Student (String nameS, String nameC) {
		name=nameS;
		course=new Course (nameC);
	}
	public Student (String nameS, Course course) {
		name=nameS;
		course.setName("CMSC 226");
		this.course=new Course (course);
	}
	public void setName(String n) {
		name=n;
	}
	public String getName() {
		return name;
	}
	public void setCourse(Course c) {
		course.setName(c.getName());
	}
	public Course getCourse() {
		return new Course(course);
	}
	public String toString() {
		return "Name: "+name+"\nCourse: "+course;	
	}
}
