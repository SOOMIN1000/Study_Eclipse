
public class TelNum {
	private int nation_code;
	private int region_number;
	private int switch_number;
	private int line_number;
	
	TelNum(int nc,int rgn,int swn,int ln)
	{
		nation_code=nc;
		region_number=rgn;
		switch_number=swn;
		line_number=ln;
	}
	public String toString() {
		String str;
		str=String.format(", telNo=%03d-%02d-%04d-%04d)",nation_code,region_number,switch_number,line_number);
		//TelNum객체를 출력할때 string타입으로 반환받아 출력하기 위함
		return str;
	}
}
