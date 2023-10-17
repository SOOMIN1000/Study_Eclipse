
public class Person {
	private String name;
	private TelNum telNum;
	
	Person(String nm, TelNum tel)//인수로 name과 TelNum타입 객체를 받음
	{
		name=nm;
		telNum=tel;
	}
	
	String getName()
	{
		return name; //name을 반환
	}
	
	public String toString()
	{
		String str;
		str=String.format("Person(name=%5s"+telNum, name); 
		//Person객체를 출력할때 String타입으로 반환해서 출력하기 위함
		return str;
	}
}
