
public class Truck extends Vehicle{
	private int cargo_capa; // cargo capacity in ton
	public Truck(String color, String vtype, int eng_capa, Person driver, int cargo_capa) 
	{
		super(color, vtype, eng_capa, driver); //상위 클래스의 생성자를 호출
		this.cargo_capa=cargo_capa; //cargo_capa를 설정 후 생성
	}
	public int getCagoCapa() 
	{
		return this.cargo_capa; //truck객체의 cargo_capa를 반환
	}
	
	public String toString() 
	{
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		//System.out.printf("%s (driver : %s) ", getVtype(), getDriver()); 이렇게 출력
		return str; //truck 객체의 정보를 쉽게 출력하기 위해 이용

	}
	@Override
	public void forward(int speed) 
	{
		System.out.printf("moving forword at speed %d Km/h; ",speed);
		//interface에서 정의했던 forward 함수를  truck 객체에 맞게 구체적으로 구현
	}
	@Override
	public void turn(int angle) 
	{
		System.out.printf("turning %d degree; ", angle);
		//interface에서 정의했던 turn 함수를 truck 객체에 맞게 구체적으로 구현
	}
	@Override
	public void stop() 
	{
		System.out.println("stopping;");
		//interface에서 정의했던 stop 함수를 truck 객체에 맞게 구체적으로 구현
	}

}
