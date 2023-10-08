
public class bus extends Vehicle{
	private int num_seats;
	private int num_passengers;
	public bus(String color, String vtype, int eng_capa, Person driver, int num_seats) 
	{
		super(color,vtype,eng_capa,driver); //�θ� ��ü�� �����ڸ� �ҷ��� ���� ��
		this.num_seats=num_seats; //�ڽ��� ���� �������� ���� �� ����
	}
	public String toString() {
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		//System.out.printf("%s (driver : %s) ", getVtype(), getDriver()); �̷��� ���
		return str; //bus ��ü�� ������ ����� �� �̿�
	}
	
	@Override
	public void forward(int speed) {
		System.out.printf("moving forword at speed %d Km/h; ",speed);
		//interface���� �����ߴ� forward �Լ��� bus ��ü�� �°� ��ü������ ����
	}
	@Override
	public void turn(int angle) {
		System.out.printf("turning %d degree; ", angle);
		//interface���� �����ߴ� turn �Լ��� bus ��ü�� �°� ��ü������ ����
	}
	@Override
	public void stop() 
	{
		System.out.println("stopping;");
		//interface���� �����ߴ� stop �Լ��� bus��ü�� �°� ��ü������ ����
	}

}
