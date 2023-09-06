/*
 * 파일명 : "HW01_2_Dynamic_Fibonacci"
 * 프로그램의 목적 및 기본 기능 : 
 * 		-주어진 정수 n에 대한 n번째 피보나치 수열을 동적 프로그래밍 구조로 계산하는 프로그램
 * 
 * 		프로그램 작성자 : 천수민 (2023년 9월 6일)
 * 		최종 Update : 2023년 9월 6일
 * 
 * =================================================================================
 * 프로그램 수정/보완 이력
 * =================================================================================
 * 프로그램 수정/보완작업자	일자			수정/보완내용
 * 천수민					2023/09/06	동적 프로그래밍 구조의 피보나치 수열 계산기능 완성
 * */
package HW01_2_Dynamic_Fibonacci;
import java.util.Scanner;

public class Dyn_Fibonacci {
	
	//static 으로 선언하여 프로그램 실행시 자동으로 생성됨
	final static int max_n = 1000; //최대 크기 max_n을 1000으로 고정 
	static double[] fb_n_tbl = new double[max_n];
	static boolean fb_n_tbl_initialized = false;

	public static double Dyn_Fibonacci(int n) {
		if (fb_n_tbl_initialized == false) //fb_n_tbl의 원소를 모두 0으로 초기화 
		{
			for (int i = 0; i < max_n; i++)
				fb_n_tbl[i] = 0;
			fb_n_tbl_initialized = true;
		}
		if (fb_n_tbl[n] != 0) //이전 피보나치 값을 이용할 때 다시계산 하지 않게끔 이전에 수행한 값을 확인하고 반영하기 위함
		{
			return fb_n_tbl[n];
		} 
		else if ((n == 1) || (n == 0)) // 0번째 피보나치 수열의 값은 0, 1번째 피보나치 수열의 값은 1임
		{
			fb_n_tbl[n] = n;
			return n;
		} 
		else //n이 만약 0이나 1이 아니라면 n-2의 값과 n-1의 값을 더함(피보나치 공식과 동일)
		{
			double fb_n = Dyn_Fibonacci(n - 2) + Dyn_Fibonacci(n - 1);//n번째 피보나치 값을 구함
			fb_n_tbl[n] = fb_n; //피보나치 배열의 n번째에 n번째 값을 넣음
			return fb_n; 
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n;
		double fibo_n;

		while (true)// -1이 나오기 전까지는 계속 무한 반복
		{
			System.out.print("input n (>= 0) to find 0 ~ nth fibo_n (-1 to terminate) : ");
			n = cin.nextInt();// 변수 n에 입력받은 값을 받아옴
			if (n == -1)// -1입력시 while문 탈출
				break;
			for (int i = 0; i <= n; i++) //-1이 아닐경우 입력받은 값의 피보나치 값까지 출력
			{
				fibo_n = Dyn_Fibonacci(i);
				System.out.printf("%3d-th Fibonacci Series = %25.0f\n", i, fibo_n);
			}
		}
		cin.close();
	}
}
