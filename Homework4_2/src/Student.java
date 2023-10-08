
public class Student extends Person implements StudentActivity{
	//Person�� ���� Ŭ������ Student
	private int st_id; // data member, student_id
	private double gpa; // data member, grade point average
	private String school; 
	private String major;
	public Student(String nm, int reg_id, String school, String major, int st_id, double st_gpa) 
	{
		super(nm,reg_id); //���� Ŭ������ Person�� �����ڸ� ȣ��
		this.school=school;
		this.major=major;
		this.st_id=st_id;
		this.gpa=st_gpa;
		//student�� �ٸ� �������� ���� �� ��ü ����
	}
	
	public String toString()
	{
		String str=String.format("Student (%s, %8d, %s, %s, %d)",getName(),getRegID(),this.school,this.major,getStID());
		return str; //student�� ������ ����� �� �̿�
	}
	public int getStID() {
		return st_id; //student��ü�� st_id�� ��ȯ
	}
	
	@Override
	public void listen() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s lietsning ... \n",str);
		//person activity�� listen �Լ��� student��ü�� �°� �� ��ü������ ����
	}
	@Override
	public void talk() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s talking ... \n",str);
		//person activity�� talk �Լ��� student��ü�� �°� �� ��ü������ ����
	}
	@Override
	public void move() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s moving ... \n",str);
		//person activity�� move �Լ��� student��ü�� �°� �� ��ü������ ����
	}
	@Override
	public void study() {
		String str=String.format("student (%s, %d) :: ", getName(),getStID());
		System.out.printf("%s studying ... \n",str);
		//student activity�� study �Լ��� student��ü�� �°� �� ��ü������ ����
	}
}
