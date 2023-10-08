
public class bus extends Vehicle{
	private int num_seats;
	private int num_passengers;
	public bus(String color, String vtype, int eng_capa, Person driver, int num_seats) 
	{
		super(color,vtype,eng_capa,driver); //부모 객체의 생성자를 불러서 생성 후
		this.num_seats=num_seats; //자식의 남은 정보들을 설정 후 생성
	}
	public String toString() {
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		//System.out.printf("%s (driver : %s) ", getVtype(), getDriver()); 이렇게 출력
		return str; //bus 객체의 정보를 출력할 때 이용
	}
	
	@Override
	public void forward(int speed) {
		System.out.printf("moving forword at speed %d Km/h; ",speed);
		//interface에서 정의했던 forward 함수를 bus 객체에 맞게 구체적으로 구현
	}
	@Override
	public void turn(int angle) {
		System.out.printf("turning %d degree; ", angle);
		//interface에서 정의했던 turn 함수를 bus 객체에 맞게 구체적으로 구현
	}
	@Override
	public void stop() 
	{
		System.out.println("stopping;");
		//interface에서 정의했던 stop 함수를 bus객체에 맞게 구체적으로 구현
	}

}
