
public class Teacher extends Person implements TeacherActivity{
	String school;
	String major;
	String lecture;
	public Teacher(String nm, int reg_id, String school, String major, String lecture) 
	{
		super(nm,reg_id);//Person�� �����ڸ� ȣ��
		this.school=school; 
		this.major=major;
		this.lecture=lecture;
		//Teacher�� ������ ���� �� Teacher��ü ����
	}
	
	public String toString()
	{
		String str=String.format("Teacher (%s, %8d, %s, %s, %s),",getName(),getRegID(),this.school,getMajor(),this.lecture );
		return str;
		//Teacher��ü�� ������ ����� �� �̿�
	}
	public String getMajor()
	{
		return major;
		//Teacher��ü�� major�� ��ȯ
	}
	
	
	@Override
	public void listen() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s lietsning ... \n",str);
		//person activity�� listen �Լ��� Teacher��ü�� �°� �� ��ü������ ����
	}
	@Override
	public void talk() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s talking ... \n",str);
		//person activity�� talk �Լ��� Teacher��ü�� �°� �� ��ü������ ����
	}
	@Override
	public void move() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s moving ... \n",str);
		//person activity�� move �Լ��� Teacher��ü�� �°� �� ��ü������ ����
	}
	@Override
	public void teach() {
		String str=String.format("teacher (%s, %s) :: ", getName(),this.major);
		System.out.printf("%s teaching ... \n",str);
		//Teacher activity�� teach �Լ��� Teacher��ü�� �°� �� ��ü������ ����
	}

}
