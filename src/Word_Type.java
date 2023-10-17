public class Word_Type {
	private String word;
	private String type;
	
	//class Word_Type의 생성자 (인수로 word와 type을 모두받을때)
	Word_Type(String word,String type)
	{
		this.word=word;
		this.type=type;
	}
	
	//Word_Type객체를 출력할때 String 형으로 출력하기 위함
	public String toString()
	{
		String str;
		str=String.format("%s_%s", word,type);
		return str;
	}
}
