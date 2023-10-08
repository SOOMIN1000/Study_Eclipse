
public class Person { 
	private String name; //이름
	private int reg_ID; //지역
	static int num_person; 
	public Person() { } // default constructor
	public Person(String nm, int reg_ID) {
	this.name = nm;
	this.reg_ID = reg_ID;
	num_person += 1;
	}
	public String toString() {
	String str = String.format("Person(name: %s, reg_id: %d)", this.name, this.reg_ID);
	return str; //Person 객체를 출력할 때 이용
	}
	protected String getName() {
	return this.name; //현재 객체의 name을 반환받음
	}
	protected int getRegID() {
	return this.reg_ID; //현재 객체의 reg_ID를 반환받음
	}
}
