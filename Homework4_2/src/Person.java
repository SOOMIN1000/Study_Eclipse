
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
		return str; //Person��ü�� name�� ��ȯ
	}
	public int getRegID()
	{
		return this.reg_id; //Person��ü�� reg_id�� ��ȯ
	}
}
