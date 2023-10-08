
public abstract class Person implements PersonActivity{
	private String name; // data member
	private int reg_id; // registration ID
	public Person(String nm, int reg_id) { // constructor
		name=nm;
		this.reg_id=reg_id;
	}
	public String getName()
	{
		String str=String.format("%s",name);
		return str; //Person객체의 name을 반환
	}
	public int getRegID()
	{
		return this.reg_id; //Person객체의 reg_id를 반환
	}
}
