import java.util.ArrayList;

public class Thesaurus {
	private String keyword;
	private String type;
	private ArrayList<String> list_thesaurus;
	
	//class Thesaurus의 생성자
	Thesaurus()
	{
		list_thesaurus=new ArrayList<String>();
	}
	
	//keyword를 설정
	public void setKeyWord(String keyword) {
		this.keyword=keyword;
	}
	
	//type을 설정
	public void setType(String type) {
		this.type=type;
	}

	//list_thesaurus에 단어들을 추가하는 기능
	public void addThesaurus(String word) {
		list_thesaurus.add(word);
	}
	
	//Thesaurus객체를 출력할때 String형으로 출력하기위함
	public String toString()
	{
		String str;
		str=String.format("%s [%s] : %s", keyword,type,list_thesaurus);
		return str;
	}

}
