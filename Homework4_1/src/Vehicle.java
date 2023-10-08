
public abstract class Vehicle implements I_Drive {
	private String v_type; // vehicle type : Sedan, Bus, Truck
	private int eng_capa; 
	private String v_color; //차의 색깔
	private Person driver; //운전자
	public Vehicle(String color, String vtype, int eng_capa, Person driver) {
		//생성자
		v_color=color;
		v_type=vtype;
		this.eng_capa=eng_capa;
		this.driver=driver;
		
	}
	public String toString() 
	{
		String str=String.format("%s (driver : %s) ", getVtype(),getDriver());
		return str; //vehicle 객체를 출력할 때 이용
	}
	public String getVtype() 
	{
		String str=String.format("%s", this.v_type);
		return str; //현재 vehicle 객체의 v_type(차량종류를 반환받음)
	}
	public int getEngCapa() 
	{
		return eng_capa; //현재 vehicle 객체의 eng_capa를 반환받음
	}
	public String getColor() 
	{
		String str=String.format("%s", v_color);
		return str; //현재 vehicle 객체의 v_color를 반환받음
	}
	public String getDriver() 
	{
		String str=String.format("%s", driver.getName());
		return str; //현재 vehicle객체의 Person의 name을 가져옴
	}

}
