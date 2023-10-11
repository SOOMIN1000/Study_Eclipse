/*
 * 파일명: "Homework5_1"
 * 프로그램의목적및기본기능: 
 *  -파일 입출력을 이해하고 이를 이용하여 텍스트에 간단한 학생 정보를 입력 후
 *   이를 읽어와 학생 객체 배열을 만들어 이를 key값,오름차, 내림차를 이용하여
 *   정렬하고 console 파일 출력 해보는 프로그램
 * 프로그램작성자: 천수민(2023년10월11일)
 * 최종Update : 2023년10월11일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/10/11	각 class(Person,Student,StudentArray)
 *                              구현,테스트 기능 구현
 *                              
 * */

import java.util.Scanner;
import java.io.*;


public class App_Students_FileIO {
	public static void main(String[] args) throws IOException {
		final String fin_name = "C:\\Users\\PC\\eclipse-workspace\\Homework5_1\\students.txt";
		final String fout_name = "C:\\Users\\PC\\eclipse-workspace\\Homework5_1\\processed_students.txt";
		StudentArray students = new StudentArray(); //StudentArray 객체를 만듬
		Scanner fin = new Scanner(new File(fin_name));//파일에서 읽어옴
		FileWriter fout = new FileWriter(fout_name);//읽어온 내용을 씀
		students.fget_students(fin);//읽어온 내용을 fget_student로 student객체에 넣음
		
		System.out.print("Before sorting : ");
		students.print_students();
		fout.write("Initial state of students :");
		students.fprint_students(fout);
		
		students.sort("name", "increasing");
		System.out.print("\nAfter sorting by name : ");
		students.print_students();
		fout.write("\nAfter sorting by name : ");
		students.fprint_students(fout);
		
		students.sort("st_id", "increasing");
		System.out.print("\nAfter sorting by st_id : ");
		students.print_students();
		fout.write("\nAfter sorting by reg_id : ");
		students.fprint_students(fout);
		
		students.sort("GPA", "decreasing");
		System.out.print("\nAfter sorting by GPA : ");
		students.print_students();
		fout.write("\nAfter sorting by GPA : ");
		students.fprint_students(fout);
		fout.close();
		}
}
