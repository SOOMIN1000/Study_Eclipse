
public class Teacher extends Person implements TeacherActivity{
	String school;
	String major;
	String lecture;
	public Teacher(String nm, int reg_id, String school, String major, String lecture) 
	{
		super(nm,reg_id);//Person의 생성자를 호출
		this.school=school; 
		this.major=major;
		this.lecture=lecture;
		//Teacher의 정보를 설정 후 Teacher객체 생성
	}
	
	public String toString()
	{
		String str=String.format("Teacher (%s, %8d, %s, %s, %s),",getName(),getRegID(),this.school,getMajor(),this.lecture );
		return str;
		//Teacher객체의 정보를 출력할 때 이용
	}
	public String getMajor()
	{
		return major;
		//Teacher객체의 major를 반환
	}
	
	
	@Override
	public void listen() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s lietsning ... \n",str);
		//person activity의 listen 함수를 Teacher객체에 맞게 끔 구체적으로 구현
	}
	@Override
	public void talk() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s talking ... \n",str);
		//person activity의 talk 함수를 Teacher객체에 맞게 끔 구체적으로 구현
	}
	@Override
	public void move() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s moving ... \n",str);
		//person activity의 move 함수를 Teacher객체에 맞게 끔 구체적으로 구현
	}
	@Override
	public void teach() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s teaching ... \n",str);
		//Teacher activity의 teach 함수를 Teacher객체에 맞게 끔 구체적으로 구현
	}

}
