/*
 * 파일명: "Homework4_2"
 * 프로그램의목적및기본기능: 
 *  -클래스의 상속을 이해하고 interface를 이용하여 관리하고 간단하게 테스트
 *   해보는 프로그램 (사람이라는 상위 클래스를 두고 학생과 선생이라는 
 *   하위 클래스의 구조로 구현하였음)
 * 프로그램작성자: 천수민(2023년10월8일)
 * 최종Update : 2023년10월8일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/10/8	interface와 각 class(사람,학생,선생
 *                              을 구현하고 test(App)을 구현
 * */ 
public class App_Student_Teacher_Interfaces_Polymorphism {
	public static void main(String[] args) {
		Person[] persons = { 
		new Student("Kim", 201203, "YNU", "ICE", 11111, 97.5), 
		new Student("Lee", 220315, "YNU", "ICE", 12333, 92.8),
		new Student("Park", 210125, "YNU", "ME", 22311, 88.8), 
		new Teacher("Choi", 110305, "YNU", "ICE", "Java"), 
		new Teacher("Yoon", 100720, "YNU", "ICE", "Python"),
		new Teacher("Hong", 110630, "YNU", "ME", "Electronics")
		};
		System.out.print("persons = [\n");
		for (int i=0; i< persons.length; i++) 
		{
		System.out.print(persons[i]);
		if (i < persons.length - 1)
		System.out.print(", "); 
		if (((i+1) % 2) == 0)
		System.out.printf("\n "); 
		}
		System.out.print("]");
		System.out.println("\nChecking the interfaces :");
		Person p0 = persons[0]; p0.talk();
		Student s0 = (Student) persons[0]; s0.study();
		Student s1 = (Student) persons[1]; s1.study();
		Person p2 = persons[2]; p2.listen();
		Student t2 = (Student) persons[2]; t2.move();
		Person p3 = persons[3]; p3.move();
		Teacher t3 = (Teacher) persons[3]; t3.move();
		Teacher t4 = (Teacher) persons[4]; t4.teach();
		Teacher t5 = (Teacher) persons[5]; t5.talk(); }
}
