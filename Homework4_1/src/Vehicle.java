
public abstract class Vehicle implements I_Drive {
	private String v_type; // vehicle type : Sedan, Bus, Truck
	private int eng_capa; 
	private String v_color; //���� ����
	private Person driver; //������
	public Vehicle(String color, String vtype, int eng_capa, Person driver) {
		//������
		v_color=color;
		v_type=vtype;
		this.eng_capa=eng_capa;
		this.driver=driver;
		
	}
	public String toString() 
	{
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		return str; //vehicle ��ü�� ����� �� �̿�
	}
	public String getVtype() 
	{
		String str=String.format("%s", this.v_type);
		return str; //���� vehicle ��ü�� v_type(���������� ��ȯ����)
	}
	public int getEngCapa() 
	{
		return eng_capa; //���� vehicle ��ü�� eng_capa�� ��ȯ����
	}
	public String getColor() 
	{
		String str=String.format("%s", v_color);
		return str; //���� vehicle ��ü�� v_color�� ��ȯ����
	}
	public String getDriver() 
	{
		String str=String.format("%s", driver.getName());
		return str; //���� vehicle��ü�� Person�� name�� ������
	}

}
