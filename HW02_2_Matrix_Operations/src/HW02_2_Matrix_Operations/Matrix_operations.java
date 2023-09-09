package HW02_2_Matrix_Operations;
/*
 * 파일명: "HW02_2_Matrix_operations"
 * 프로그램의목적및기본기능: 
 *  -행렬의 덧셈, 뺼셈, 곱셈을 구현하고 출력하는 프로그램
 * 프로그램작성자: 천수민(2023년9월9일)
 * 최종Update : 2023년9월9일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/09/09	행렬 덧셈,뺄셈,곱셈,출력 기능 구현
 * */

public class Matrix_operations {	 
	public static void printMtrx(String mtrx_name, int n_row, int n_col, double mtrx_data[][])
	{//행렬 출력
		System.out.println(mtrx_name+" = "); //행렬 이름을 먼저 출력 후 개행
		for(int i=0;i<n_row;i++) //[0][0]~[n_row][n_col]까지
		{
			for(int j=0;j<n_col;j++)//먼저[0][0]~[0][n_col]까지 출력
			{
				System.out.printf("%5.2f  ",mtrx_data[i][j]);
			}
			System.out.println();//개행
		}
		System.out.println();//개행
	}
	
	public static double[][] addMtrx(int n_row, int n_col, double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c;//double형 2차원배열 Mtrx_c 생성
		Mtrx_c=new double[n_row][n_col];//크기를 [n_row][n_col]로 설정
		for(int i=0;i<n_row;i++) {//
			for(int j=0;j<n_col;j++)
			{
				Mtrx_c[i][j]=mA_data[i][j]+mB_data[i][j];//각 위치의 원소를 더한 값을 Mtrx_c에 저장
			}
		}
		
		return Mtrx_c; //mA와 mB행렬을 더한 Mtrx_c를 반환
	}
	
	public static double[][] subMtrx(int n_row, int n_col, double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c; //double형 2차원 배열 Mtrx_c 생성
		Mtrx_c=new double[n_row][n_col]; //크기를 [n_row][n_col]로 설정
		for(int i=0;i<n_row;i++) {
			for(int j=0;j<n_col;j++)
			{
				Mtrx_c[i][j]=mA_data[i][j]-mB_data[i][j];//mA의 각 위치와 동일한 위치 원소에서 mB의 원소를 뺌
			}
		}
		
		return Mtrx_c; //mA-mB한 Mtrx_c행렬을 반환
	}
	
	public static double[][] mulMtrx(int nA_row, int nA_col, int nB_row, int nB_col, double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c; //double형 2차원 배열 Mtrx_c를 생성
		Mtrx_c=new double[nA_row][nB_col];//nA_row*nA_col행렬과 nB_row*nB_col 행렬을 
		                                  //곱한 행렬의 크기는 nA_row*nB_col임
		for (int r=0; r<nA_row; r++) //Mtrx_c의 각 원소를 0행~nA_row-1행 순서로 차례대로 구할 것임
		{
			for (int c=0; c<nB_col; c++) 
			{
				Mtrx_c[r][c] = 0; //해당 위치의 원소를 먼저 0으로 만듬
				for (int k=0; k<nA_col; k++) 
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
	int nA_row = 3, nA_col = 5;
	int nB_row = 3, nB_col = 5;
	int nC_row = 5, nC_col = 3;
	double mA[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
	double mB[][] = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}};
	double mAddAB[][];
	double mSubAB[][];
	printMtrx("mA", nA_row, nA_col, mA);
	printMtrx("mB", nB_row, nB_col, mB);
	mAddAB = addMtrx(nA_row, nA_col, mA, mB);
	printMtrx("mAddAB", nA_row, nA_col, mAddAB);
	mSubAB = subMtrx(nA_row, nA_col, mA, mB);
	printMtrx("mSubAB", nA_row, nA_col, mSubAB);
	double mC[][] = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, 0}, {0, 0, 0}};
	double mMulAC[][];
	printMtrx("mA", nA_row, nA_col, mA);
	printMtrx("mC", nC_row, nC_col, mC);
	mMulAC = mulMtrx(nA_row, nA_col, nC_row, nC_col, mA, mC);
	printMtrx("mMulAC", nA_row, nC_col, mMulAC);
	}

}
