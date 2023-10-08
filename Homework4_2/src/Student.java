
public class Student extends Person implements StudentActivity{
	//Person의 하위 클래스인 Student
	private int st_id; // data member, student_id
	private double gpa; // data member, grade point average
	private String school; 
	private String major;
	public Student(String nm, int reg_id, String school, String major, int st_id, double st_gpa) 
	{
		super(nm,reg_id); //상위 클래스인 Person의 생성자를 호출
		this.school=school;
		this.major=major;
		this.st_id=st_id;
		this.gpa=st_gpa;
		//student의 다른 정보들을 설정 후 객체 생성
	}
	
	public String toString()
	{
		String str=String.format("Student (%s, %8d, %s, %s, %d)",getName(),getRegID(),this.school,this.major,getStID());
		return str; //student의 정보를 출력할 때 이용
	}
	public int getStID() {
		return st_id; //student객체의 st_id를 반환
	}
	
	@Override
	public void listen() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s lietsning ... \n",str);
		//person activity의 listen 함수를 student객체에 맞게 끔 구체적으로 구현
	}
	@Override
	public void talk() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s talking ... \n",str);
		//person activity의 talk 함수를 student객체에 맞게 끔 구체적으로 구현
	}
	@Override
	public void move() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s moving ... \n",str);
		//person activity의 move 함수를 student객체에 맞게 끔 구체적으로 구현
	}
	@Override
	public void study() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s studying ... \n",str);
		//student activity의 study 함수를 student객체에 맞게 끔 구체적으로 구현
	}
}
