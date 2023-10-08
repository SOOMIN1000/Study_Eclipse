
public class Truck extends Vehicle{
	private int cargo_capa; // cargo capacity in ton
	public Truck(String color, String vtype, int eng_capa, Person driver, int cargo_capa) 
	{
		super(color, vtype, eng_capa, driver); //���� Ŭ������ �����ڸ� ȣ��
		this.cargo_capa=cargo_capa; //cargo_capa�� ���� �� ����
	}
	public int getCagoCapa() 
	{
		return this.cargo_capa; //truck��ü�� cargo_capa�� ��ȯ
	}
	
	public String toString() 
	{
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		//System.out.printf("%s (driver : %s) ", getVtype(), getDriver()); �̷��� ���
		return str; //truck ��ü�� ������ ���� ����ϱ� ���� �̿�

	}
	@Override
	public void forward(int speed) 
	{
		System.out.printf("moving forword at speed %d Km/h; ",speed);
		//interface���� �����ߴ� forward �Լ���  truck ��ü�� �°� ��ü������ ����
	}
	@Override
	public void turn(int angle) 
	{
		System.out.printf("turning %d degree; ", angle);
		//interface���� �����ߴ� turn �Լ��� truck ��ü�� �°� ��ü������ ����
	}
	@Override
	public void stop() 
	{
		System.out.println("stopping;");
		//interface���� �����ߴ� stop �Լ��� truck ��ü�� �°� ��ü������ ����
	}

}
