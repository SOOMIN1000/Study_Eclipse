public class Sedan extends Vehicle{
	private int num_seats;
	public Sedan(String color, String vtype, int eng_capa, Person driver, int num_seats) 
	{
		super(color,vtype,eng_capa,driver); //상위 클래스의 생성자를 호출
		this.num_seats=num_seats; //sedan객체의 다른 정보들도 설정 후 생성
	}
	public String toString() 
	{
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		//System.out.printf("%s (driver : %s) ", getVtype(), getDriver()); 이렇게 출력
		return str; //sedan객체의 정보를 출력할때 이용
	}
	
	@Override
	public void forward(int speed) 
	{
		System.out.printf("moving forword at speed %d Km/h; ",speed);
		//interface에서 정의했던 forward 함수를 sedan 객체에 맞게 구체적으로 구현
	}
	@Override
	public void turn(int angle) 
	{
		System.out.printf("turning %d degree; ", angle);
		//interface에서 정의했던 turn 함수를 sedan 객체에 맞게 구체적으로 구현
	}
	@Override
	public void stop() 
	{
		System.out.println("stopping;");
		//interface에서 정의했던 stop 함수를 sedan 객체에 맞게 구체적으로 구현
	}
}
