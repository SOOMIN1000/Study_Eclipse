
public class Student extends Person{
	int st_id;
	String dept;
	String school;
	double GPA;
	Student(String nm,int reg_ID,int st_id,String dept,String school,double gpa)
	{//Student 객체의 생성자
		super(nm,reg_ID);//부모 클래스인 Person의 생성자 호출
		this.st_id=st_id; //나머지 변수들 설정 후 생성
		this.dept =dept;
		this.school=school;
		GPA=gpa;
	}
	public String toString()//Student 객체의 정보를 문자로 반환
	{
		String str=String.format("Student(name: %-8s, reg_id : %-8d, school: %-8s dept: %-8s, st_id: %-8d,GPA: %-4.2f)\n",
				this.name,this.reg_id,this.school,this.dept,this.st_id,this.GPA);
		return str;
		
	}
	public int compareStudent(String key_attr,Student other)
	{ //other보다 key_attr가 크면 1 같으면 0 다르면 -1을 반환
		if(key_attr=="st_id") { 
			if(st_id>other.st_id)
				return 1;
			else if(st_id==other.st_id)
				return 0;
			else
				return -1;
		}
		if(key_attr=="dept")
		{
			if(dept.compareTo(other.dept)>0)
				return 1;
			else if(dept.compareTo(other.dept)==0)
				return 0;
			else
				return -1;
		}
		if(key_attr=="school")
		{
			if(school.compareTo(other.school)>0)
				return 1;		
			else if(school.compareTo(other.school)==0)
				return 0;
			else
				return -1;
		}
		if(key_attr=="GPA")
		{
			if(GPA>other.GPA)
				return 1;
			else if(GPA==other.GPA)
				return 0;
			else
				return -1;
		}
		if(key_attr=="name")
		{
			if(name.compareTo(other.name)>0)
				return 1;
			else if(name.compareTo(other.name)==0)
				return 0;
			else
				return -1;
		}
		else//reg_id라면 
		{
			if(reg_id>other.reg_id)
				return 1;
			else if(reg_id==other.reg_id)
				return 0;
			else
				return -1;
		}
		
	}

}
