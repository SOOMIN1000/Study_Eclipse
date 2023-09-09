
import java.util.Scanner;

/*
 * ���ϸ�: "HW02_1_BigRandArray_QuickSort_EX"
 * ���α׷��Ǹ����ױ⺻���: 
 *  -32767�̻��� ũ��(bigSize)ũ���� ��� ���Ұ� �ߺ������ʴ�
 *  ������ ����(0~bigSize+offset)�� ������ �迭�� �����ϰ� �������ϰ�
 *  �ش� �迭�� ������ ����ϴ� ���α׷� 
 *  (ó�� 10���� 2��, ������ 10���� 2��)
 *  
 * ���α׷��ۼ���: õ����(2023��9��9��)
 * ����Update : 2023��9��9��
 * =========================================================
 * ���α׷�����/�����̷�
 * =========================================================
 * ���α׷�����/����		�۾�������		����/���ϳ���
 * õ����				2023/09/09	�迭ũ���Է�,��������,������ ����
 * */

public class BigRandArray_QuickSort_Ex {
	public static int[] genBigRandIntArray(int size, int offset) {
		int[] bigIntArray = new int[size]; // ���޹��� ���� size ��ŭ�� ũ�⸦ ������ �迭 ����
		int j, temp;
		for (int i = 0; i < size; i++)
			bigIntArray[i] = i + offset; // 0~size-1��° �迭�� offset���� ū ���� ������� ����
		/* shuffle */
		for (int i = 0; i < size; i++) {
			j = (int) (Math.random() * size);// j�� 0~size������ ������ random�ϰ� ����
			if (j == i) // ���� i���� j ���� �״�θ� ��� �׷��� �ʴٸ� i�� j�� ���Ҹ� ���� �ٲ��� (shuffle)
				continue;
			temp = bigIntArray[i];
			bigIntArray[i] = bigIntArray[j];
			bigIntArray[j] = temp;
		}
		return bigIntArray;//���� �迭�� �״�� ����
	}

	public static void printBigArraySample(int[] bigArray, int size, int per_line, int sample_lines) {
		int count = 0;
		
		for (int i=0; i<sample_lines; i++) 
		{
		 for (int j = 0; j < per_line; j++) 
		 {
		  if (count > size)//���� ����� ������ ��ü size���� ũ�� �������ϱ⶧�� 
		  {
		   System.out.printf("\n");
		   return;
		  }
		  System.out.printf("%8d ", bigArray[count]);//per_line��ŭ �����
		  count++;//����Ҷ����� ����� ���� ����
		 }
		 System.out.printf("\n");//���� �� ����ϸ� ����
		}
		
		if (count < (size - per_line * sample_lines))//����� ������ ����ؾ��� �������� ������
		 count = size - per_line * sample_lines; //count�� ���������� ����
		System.out.println("\n . . . . . \n"); //���� ǥ��
		
		//���� ������ ������� ���
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
		temp = array[pivotIndex];//temp��� �ӽ� ������ pivotIndex��ġ�� ���Ҹ� ��Ƴ���
		array[pivotIndex] = array[right];//�������� �迭���� ���� �������� ���� pivotIndex�� ����
		array[right] = temp; // �������� �迭���� ���� ���ʿ� pivot���� �Ѱ��� 
		newPI = left; //���ο� pivot�� ������ġ 
		for (i = left; i <= (right - 1); i++)//�������� �迭�� �� ó������ ������ 
		{
		if (array[i] <= pivotValue)//���� �ش���ġ�� ���� pivot������ �۰ų� ������� ��ȯ�� pivot=pivot+1 
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
		return newPI; //���ο� pivot��ġ�� ��ȯ 
	}

	public static void _quickSort(int[] array, int size, int left, int right) {
		int pI, newPI; // pivot index
		if (left >= right)//��� �����ٵ� ���� ���� ������ index�� ���� �������� index�� ���ٸ� �������������Ƿ� 
		{
		return;
		}
		pI = (left + right) / 2; //pivot��ġ�� �߰�������
		newPI = _partition(array, size, left, right, pI);
		if (left < (newPI - 1)) {//���ʺκ� quicksort
			_quickSort(array, size, left, newPI - 1);
		}
		if ((newPI + 1) < right) {//�����ʺκ� quicksort
			_quickSort(array, size, newPI + 1, right);
		}
	}

	public static void quickSort(int[] array, int size) {
		_quickSort(array, size, 0, size - 1);//�� ó�����¿����� �ǿ����� index�� 0 �������� size-1��
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
