
public class Person { 
	private String name; //�̸�
	private int reg_ID; //����
	static int num_person; 
	public Person() { } // default constructor
	public Person(String nm, int reg_ID) {
	this.name = nm;
	this.reg_ID = reg_ID;
	num_person += 1;
	}
	public String toString() {
	String str = String.format("Person(name: %s, reg_id: %d)", this.name, this.reg_ID);
	return str; //Person ��ü�� ����� �� �̿�
	}
	protected String getName() {
	return this.name; //���� ��ü�� name�� ��ȯ����
	}
	protected int getRegID() {
	return this.reg_ID; //���� ��ü�� reg_ID�� ��ȯ����
	}
}
