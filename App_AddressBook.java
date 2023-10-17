/*
 * 파일명: "Homework6_1"
 * 프로그램의목적및기본기능: 
 *  -private data member로 정수형,nation_code,region_number,
 *   switch_number,line_number를 가지는 class TelNum과
 *   private data member로 String형 name과 TelNum클래스 자료형
 *   telNum을 가지는 class Person을 만들고 이를 테스트 부분에서
 *   TreeMap<String,Person>을 사용하여 addrBook을 구성해보고
 *   이를 이용해 키값으로 객체를 생성, 출력 해보는 프로그램  
 *   
 * 프로그램작성자: 천수민(2023년10월17일)
 * 최종Update : 2023년10월17일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/10/17	각 class(Person,TelNum)
 *                              구현, 테스트 기능 구현
 *  
 **/

import java.util.TreeMap;
import java.util.Set;

public class App_AddressBook {// 실행 테스트 부분
	public static void main(String[] args) {
		TreeMap<String, Person> addrBook = new TreeMap<String, Person>();// TreeMap<String형,Person형>으로 addrBook생성
		Person[] persons = { new Person("Kim", new TelNum(82, 53, 810, 1000)),
				new Person("Yoon", new TelNum(82, 2, 1234, 5678)), new Person("Lee", new TelNum(82, 51, 2579, 1234)),
				new Person("Park", new TelNum(82, 53, 1000, 5678)),
				new Person("Choi", new TelNum(82, 31, 2345, 6789)), };
		for (Person p : persons) {// Person배열 persons에서 getName으로 name을 받아서 addrBook에 넣음
			addrBook.put(p.getName(), p);// 키를 가져온 이름으로 value를 해당 Person객체로
		}
		for (Person p : persons) {
			String nm = p.getName();
			System.out.printf("%5s : %s\n", nm, addrBook.get(nm));
			// 해당이름, name(nm)을 키로 하여 가져옴
		}
		Set<String> keySet_name = addrBook.keySet(); // 맵의 키를 집합(set)으로 반환
		System.out.printf("keySet_name = %s\n", keySet_name);
		for (String key : keySet_name) {
			System.out.printf("%5s : %s\n", key, addrBook.get(key));
		}
	}

}
