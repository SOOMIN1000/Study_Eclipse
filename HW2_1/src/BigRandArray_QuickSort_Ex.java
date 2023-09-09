
import java.util.Scanner;

/*
 * 파일명: "HW02_1_BigRandArray_QuickSort_EX"
 * 프로그램의목적및기본기능: 
 *  -32767이상의 크기(bigSize)크기의 모든 원소가 중복되지않는
 *  정수형 원소(0~bigSize+offset)를 가지는 배열을 생성하고 퀵정렬하고
 *  해당 배열의 샘플을 출력하는 프로그램 
 *  (처음 10개씩 2줄, 마지막 10개씩 2줄)
 *  
 * 프로그램작성자: 천수민(2023년9월9일)
 * 최종Update : 2023년9월9일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/09/09	배열크기입력,난수생성,퀵정렬 구현
 * */

public class BigRandArray_QuickSort_Ex {
	public static int[] genBigRandIntArray(int size, int offset) {
		int[] bigIntArray = new int[size]; // 전달받은 변수 size 만큼의 크기를 가지는 배열 생성
		int j, temp;
		for (int i = 0; i < size; i++)
			bigIntArray[i] = i + offset; // 0~size-1번째 배열에 offset보다 큰 값을 순서대로 넣음
		/* shuffle */
		for (int i = 0; i < size; i++) {
			j = (int) (Math.random() * size);// j는 0~size까지의 정수가 random하게 생성
			if (j == i) // 만약 i값과 j 값이 그대로면 계속 그렇지 않다면 i와 j의 원소를 서로 바꿔줌 (shuffle)
				continue;
			temp = bigIntArray[i];
			bigIntArray[i] = bigIntArray[j];
			bigIntArray[j] = temp;
		}
		return bigIntArray;//섞인 배열을 그대로 리턴
	}

	public static void printBigArraySample(int[] bigArray, int size, int per_line, int sample_lines) {
		int count = 0;
		
		for (int i=0; i<sample_lines; i++) 
		{
		 for (int j = 0; j < per_line; j++) 
		 {
		  if (count > size)//만약 출력한 갯수가 전체 size보다 크면 끝내야하기때문 
		  {
		   System.out.printf("\n");
		   return;
		  }
		  System.out.printf("%8d ", bigArray[count]);//per_line만큼 출력함
		  count++;//출력할때마다 출력한 갯수 증가
		 }
		 System.out.printf("\n");//한줄 다 출력하면 개행
		}
		
		if (count < (size - per_line * sample_lines))//출력한 갯수가 출력해야할 갯수보다 작으면
		 count = size - per_line * sample_lines; //count를 남은갯수로 변경
		System.out.println("\n . . . . . \n"); //생략 표시
		
		//위와 동일한 방식으로 출력
		for (int i = 0; i < sample_lines; i++) 
		{
		 for (int j = 0; j< per_line; j++) 
		 {
		  if (count > size) 
		  {
		   System.out.println();
		   return;
		  }
		  System.out.printf("%8d ", bigArray[count]);
		  count++;
		 }
		 System.out.println();
		}
		System.out.println();
	}

	public static int _partition(int[] array, int size, int left, int right, int pivotIndex) {
		int pivotValue; // pivot value
		int newPI; // new pivot index
		int temp, i;
		pivotValue = array[pivotIndex];
		temp = array[pivotIndex];//temp라는 임시 변수에 pivotIndex위치의 원소를 담아놓음
		array[pivotIndex] = array[right];//나누어진 배열에서 가장 오른쪽의 값을 pivotIndex로 설정
		array[right] = temp; // 나누어진 배열에서 가장 끝쪽에 pivot값을 넘겨줌 
		newPI = left; //새로운 pivot은 왼쪽위치 
		for (i = left; i <= (right - 1); i++)//나누어진 배열의 맨 처음부터 끝까지 
		{
		if (array[i] <= pivotValue)//만약 해당위치의 값이 pivot값보다 작거나 같을경우 교환후 pivot=pivot+1 
		 {
		 temp = array[i]; 
		 array[i] = array[newPI];
		 array[newPI] = temp;
		 newPI = newPI + 1;
		 }
		}
		// swap array[storeIndex] and array[right]; Move pivot to its final place
		temp = array[newPI];
		array[newPI] = array[right];
		array[right] = temp;
		return newPI; //새로운 pivot위치를 반환 
	}

	public static void _quickSort(int[] array, int size, int left, int right) {
		int pI, newPI; // pivot index
		if (left >= right)//계속 나눌텐데 만약 가장 왼쪽의 index와 가장 오른쪽의 index가 같다면 나눠지지않으므로 
		{
		return;
		}
		pI = (left + right) / 2; //pivot위치를 중간값으로
		newPI = _partition(array, size, left, right, pI);
		if (left < (newPI - 1)) {//왼쪽부분 quicksort
			_quickSort(array, size, left, newPI - 1);
		}
		if ((newPI + 1) < right) {//오른쪽부분 quicksort
			_quickSort(array, size, newPI + 1, right);
		}
	}

	public static void quickSort(int[] array, int size) {
		_quickSort(array, size, 0, size - 1);//맨 처음상태에서는 맨왼쪽의 index가 0 오른쪽은 size-1임
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int big_size;
		int offset = 0;
		int[] bigRandIntArray;
		while (true) {
			System.out.print(
					"input big_size (> 32767) to generate non-duplicated random big integer array (0 to terminate) : ");
			big_size = cin.nextInt();
			if (big_size == 0)
				break;
			bigRandIntArray = genBigRandIntArray(big_size, offset);
			System.out.printf("Before sorting, size = %d, offset = %d\n", big_size, offset);
			printBigArraySample(bigRandIntArray, big_size, 10, 2);
			quickSort(bigRandIntArray, big_size);
			System.out.printf("After sorting, size = %d, offset = %d\n", big_size, offset);
			printBigArraySample(bigRandIntArray, big_size, 10, 2);
		}
		cin.close();
	}

}
