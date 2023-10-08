public class Sedan extends Vehicle{
	private int num_seats;
	public Sedan(String color, String vtype, int eng_capa, Person driver, int num_seats) 
	{
		super(color,vtype,eng_capa,driver); //���� Ŭ������ �����ڸ� ȣ��
		this.num_seats=num_seats; //sedan��ü�� �ٸ� �����鵵 ���� �� ����
	}
	public String toString() 
	{
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		//System.out.printf("%s (driver : %s) ", getVtype(), getDriver()); �̷��� ���
		return str; //sedan��ü�� ������ ����Ҷ� �̿�
	}
	
	@Override
	public void forward(int speed) 
	{
		System.out.printf("moving forword at speed %d Km/h; ",speed);
		//interface���� �����ߴ� forward �Լ��� sedan ��ü�� �°� ��ü������ ����
	}
	@Override
	public void turn(int angle) 
	{
		System.out.printf("turning %d degree; ", angle);
		//interface���� �����ߴ� turn �Լ��� sedan ��ü�� �°� ��ü������ ����
	}
	@Override
	public void stop() 
	{
		System.out.println("stopping;");
		//interface���� �����ߴ� stop �Լ��� sedan ��ü�� �°� ��ü������ ����
	}
}
