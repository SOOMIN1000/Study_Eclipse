/*
 * 파일명: "Homework6_2"
 * 프로그램의목적및기본기능: 
 *  -데이터 멤버로 String word와 String type을 가지는 
 *   class Word_type과 
 *   (Thesaurus dictionary에서 keyWord와 해당 keyWord의
 *    품사를 지정하며, HashMap<>에서 key로 사용됨)
 *   데이터 멤버로 String keyword, String type,
 *   ArrayList<String> list_thesaurus를 가지는 
 *   class Thesaurus를 구현하고
 *   HashMap<Word_Type,Thesaurus>를 기반으로 유의어 사전을
 *   구성하고, 단어와 품사를 지정하면 해당 유의어를 탐색하여 알려주는 프로그램 
 *   
 * 프로그램작성자: 천수민(2023년10월17일)
 * 최종Update : 2023년10월17일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/10/17	각 class(Word_type,Thesaurus)
 *                              구현, 테스트 기능 구현
 *  
 **/

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

//테스트 부분
public class App_HashMap_ThesaurusDict {
	public static void main(String[] args) throws IOException {
		//HashMap<Word_Type,Thesaurus> thesaurusDict 생성
		HashMap<Word_Type, Thesaurus> thesaurusDict = 
				new HashMap<Word_Type, Thesaurus>();
		//해당 경로의 file읽기
		final String fname = 
				"C:\\Users\\PC\\eclipse-workspace\\Homework6_2\\sample_thesaurus_dict.txt";
		//Scanner 객체 생성
		Scanner fin = new Scanner(new File(fname));
		//String형 변수 keyword,word,type을 생성
		String keyword, word, type;
		/*Scanner 이용하여 keyword,type변수에 넣음 
		 Thesaurus객체에 setKeyword,setType을 이용해 Thesaurus객체 생성후 설정*/
		while (fin.hasNext()) {
			String str_line = fin.nextLine();
			System.out.printf("ThesaurusDict:: processing %s\n", str_line);
			StringTokenizer strTokenizer = new StringTokenizer(str_line, " ");
			Thesaurus thesaurus = new Thesaurus();
			keyword = strTokenizer.nextToken();
			thesaurus.setKeyWord(keyword);
			type = strTokenizer.nextToken();
			thesaurus.setType(type);
			/*줄의 끝까지 읽고 해당 단어들을 Thesaurus객체의 
			  ArrayList<String> list_thesaurus에 단어들을 add함*/
			while (strTokenizer.hasMoreTokens()) {
				word = strTokenizer.nextToken();
				thesaurus.addThesaurus(word);
			}
			/*thesaurusDict에 Word_Type을 key로 하고 value를 thesaurus
			  로 하여 put함*/
			thesaurusDict.put(new Word_Type(keyword, type), thesaurus);
		}
		fin.close();//완료후 파일 닫기
		//key들을 집합(set)으로 만든 keys
		Set<Word_Type> keys = thesaurusDict.keySet();
		//출력
		System.out.printf("keys = %s\n", keys);
		Iterator<Word_Type> it = keys.iterator();
		while (it.hasNext()) {
			Word_Type keyWordType = it.next();
			Thesaurus value = thesaurusDict.get(keyWordType);
			System.out.println("key (" + keyWordType + ") : " + value + ")");
		}

	}
}
