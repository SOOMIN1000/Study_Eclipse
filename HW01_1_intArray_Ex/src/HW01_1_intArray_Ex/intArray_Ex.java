/*
 * 파일명 : "HW01_1_intArray_EX"
 * 프로그램의 목적 및 기본 기능 : 
 * 		-이 프로그램은 배열의 크기를 입력받고 배열 크기만큼의 정수를 입력받고 정렬(삽입정렬)시키는 프로그램
 * 
 * 		프로그램 작성자 : 천수민 (2023년 9월 6일)
 * 		최종 Update : 2023년 9월 6일
 * 
 * =================================================================================
 * 프로그램 수정/보완 이력
 * =================================================================================
 * 프로그램 수정/보완작업자	일자			수정/보완내용
 * 천수민					2023/09/06	배열 크기 입력,정수 입력,삽입 정렬 기능 완성
 * */

package HW01_1_intArray_Ex;
import java.util.Scanner;

public class intArray_Ex {
	public static void print_array(int[] array, int size)
	{
		for(int i=0;i<size;i++)//array[0]~array[size-1]까지 출력
		{
			System.out.print(" "+array[i]+" ");
		}
		System.out.println();//개행
	}
	
	public static int[] get_int_array(Scanner cin,int size)
	{
		//
		int[] array=new int[size]; //전달받은 size만큼의 크기를 가지는 배열을 생성
		int count=0; //배열에 0부터 입력하기 위함
		while(count!=size) //array[0]부터 size-1,즉 count가 size가 아닐때까지 count를 증가시키며 입력
		{
			array[count]=cin.nextInt();
			count++;
		}
		return array; //입력이 다된 배열을 반환
	}
	
	public static void insertion_sort(int[] array, int size)
	{
		/*sort given array with insertion_sort algorithm*/
		int temp, i, j;
		for (i = 1; i <= (size-1); i++) 
		{
		temp = array[i];
		for (j = i; j > 0 && array[j - 1] >= temp; --j) {
		array[j] = array[j-1]; 
		}
		array[j] = temp; 
		}
	}
	
	public static void main(String args[])
	{
		Scanner cin=new Scanner(System.in); 
		System.out.print("Please input number of integers to process : ");
		int num_data = cin.nextInt();
		int[] int_array;
		System.out.print("Please input " + num_data + " integers in a line, separated with space :"); 
		int_array = get_int_array(cin, num_data);
		System.out.print("Input data : ");
		print_array(int_array, num_data);
		insertion_sort(int_array, num_data);
		System.out.print("Sorted input data : ");
		print_array(int_array, num_data);
	}
}
