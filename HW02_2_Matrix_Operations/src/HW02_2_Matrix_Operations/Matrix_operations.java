package HW02_2_Matrix_Operations;
/*
 * 파일명: "HW02_2_Matrix_operations"
 * 프로그램의목적및기본기능: 
 *  -행렬의 덧셈, E셈, 곱셈을 구현하고 출력하는 프로그램
 * 프로그램작성자: 천수민(2023년9월9일)
 * 최종Update : 2023년9월9일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민			2023/09/09	행렬 덧셈,뺄셈,곱셈,출력 기능 구현
 * 천수민			2023/09/13      각 함수의 인수에서 행과 열을 빼고 
 *						함수 내에서 계산하는 것으로 바꿈
 * */

public class Matrix_operations {	 
	public static void printMtrx(String mtrx_name, double mtrx_data[][])
	{//행렬 출력
		System.out.println(mtrx_name+" = "); //행렬 이름을 먼저 출력 후 개행
		for(int i=0;i<mtrx_data.length;i++) //0행부터 끝 행 까지 반복
		{
			for(int j=0;j<mtrx_data[i].length;j++)//각 행의 끝까지 출력
			{
				System.out.printf("%5.2f  ",mtrx_data[i][j]);
			}
			System.out.println();//개행
		}
		System.out.println();//개행
	}
	
	public static double[][] addMtrx(double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c;//double형 2차원배열 Mtrx_c 생성
		int n_row=mA_data.length;
		int n_col=mA_data[0].length;
		Mtrx_c=new double[n_row][n_col];//크기를 [n_row][n_col]로 설정
		for(int i=0;i<n_row;i++) {//
			for(int j=0;j<n_col;j++)
			{
				Mtrx_c[i][j]=mA_data[i][j]+mB_data[i][j];//각 위치의 원소를 더한 값을 Mtrx_c에 저장
			}
		}
		
		return Mtrx_c; //mA와 mB행렬을 더한 Mtrx_c를 반환
	}
		
	
	public static double[][] subMtrx(double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c; //double형 2차원 배열 Mtrx_c 생성
		int n_row=mA_data.length; //행과 열의 크기가 mA의 행과 열의 크기와 같다.
		int n_col=mA_data[0].length;
		Mtrx_c=new double[n_row][n_col]; //크기를 [n_row][n_col]로 설정
		for(int i=0;i<n_row;i++) {
			for(int j=0;j<n_col;j++)
			{
				Mtrx_c[i][j]=mA_data[i][j]-mB_data[i][j];//mA의 각 위치와 동일한 위치 원소에서 mB의 원소를 뺌
			}
		}
		
		return Mtrx_c; //mA-mB한 Mtrx_c행렬을 반환
	}
	
	public static double[][] mulMtrx(double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c; //double형 2차원 배열 Mtrx_c를 생성
		int n_row=mA_data.length; //행은 mA,열은 mB의 크기와 같다.
		int n_col=mB_data[0].length;
		Mtrx_c=new double[n_row][n_col];//mA_row*mA_col행렬과 mB_row*mB_col 행렬을 
		                                  //곱한 행렬의 크기는 mA_row*mB_col임
		for (int r=0; r<n_row; r++) //Mtrx_c의 각 원소를 0행~nA_row-1행 순서로 차례대로 구할 것임
		{
			for (int c=0; c<n_col; c++) 
			{
				Mtrx_c[r][c] = 0; //해당 위치의 원소를 먼저 0으로 만듬
				for (int k=0; k<mA_data[0].length; k++) 
				{
					//행렬의 곱셈 식에 따라서 계산
					Mtrx_c[r][c] += mA_data[r][k] * mB_data[k][c];
				}
			}
		}
		return Mtrx_c; //mA와 mB행렬을 곱한 Mtrx_c행렬을 반환
	}
	
	public static void main(String[] args)
	{
	double mA[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
	double mB[][] = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}};
	double mAddAB[][];
	double mSubAB[][];
	printMtrx("mA",  mA);
	printMtrx("mB",  mB);
	mAddAB = addMtrx( mA, mB);
	printMtrx("mAddAB",  mAddAB);
	mSubAB = subMtrx(mA, mB);
	printMtrx("mSubAB", mSubAB);
	double mC[][] = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, 0}, {0, 0, 0}};
	double mMulAC[][];
	printMtrx("mA", mA);
	printMtrx("mC",  mC);
	mMulAC = mulMtrx(mA, mC);
	printMtrx("mMulAC", mMulAC);
	}

}
