package HW02_2_Matrix_Operations;
/*
 * ���ϸ�: "HW02_2_Matrix_operations"
 * ���α׷��Ǹ����ױ⺻���: 
 *  -����� ����, �E��, ������ �����ϰ� ����ϴ� ���α׷�
 * ���α׷��ۼ���: õ����(2023��9��9��)
 * ����Update : 2023��9��9��
 * =========================================================
 * ���α׷�����/�����̷�
 * =========================================================
 * ���α׷�����/����		�۾�������		����/���ϳ���
 * õ����				2023/09/09	��� ����,����,����,��� ��� ����
 * */

public class Matrix_operations {	 
	public static void printMtrx(String mtrx_name, int n_row, int n_col, double mtrx_data[][])
	{//��� ���
		System.out.println(mtrx_name+" = "); //��� �̸��� ���� ��� �� ����
		for(int i=0;i<n_row;i++) //[0][0]~[n_row][n_col]����
		{
			for(int j=0;j<n_col;j++)//����[0][0]~[0][n_col]���� ���
			{
				System.out.printf("%5.2f  ",mtrx_data[i][j]);
			}
			System.out.println();//����
		}
		System.out.println();//����
	}
	
	public static double[][] addMtrx(int n_row, int n_col, double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c;//double�� 2�����迭 Mtrx_c ����
		Mtrx_c=new double[n_row][n_col];//ũ�⸦ [n_row][n_col]�� ����
		for(int i=0;i<n_row;i++) {//
			for(int j=0;j<n_col;j++)
			{
				Mtrx_c[i][j]=mA_data[i][j]+mB_data[i][j];//�� ��ġ�� ���Ҹ� ���� ���� Mtrx_c�� ����
			}
		}
		
		return Mtrx_c; //mA�� mB����� ���� Mtrx_c�� ��ȯ
	}
	
	public static double[][] subMtrx(int n_row, int n_col, double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c; //double�� 2���� �迭 Mtrx_c ����
		Mtrx_c=new double[n_row][n_col]; //ũ�⸦ [n_row][n_col]�� ����
		for(int i=0;i<n_row;i++) {
			for(int j=0;j<n_col;j++)
			{
				Mtrx_c[i][j]=mA_data[i][j]-mB_data[i][j];//mA�� �� ��ġ�� ������ ��ġ ���ҿ��� mB�� ���Ҹ� ��
			}
		}
		
		return Mtrx_c; //mA-mB�� Mtrx_c����� ��ȯ
	}
	
	public static double[][] mulMtrx(int nA_row, int nA_col, int nB_row, int nB_col, double mA_data[][], double mB_data[][])
	{
		double[][] Mtrx_c; //double�� 2���� �迭 Mtrx_c�� ����
		Mtrx_c=new double[nA_row][nB_col];//nA_row*nA_col��İ� nB_row*nB_col ����� 
		                                  //���� ����� ũ��� nA_row*nB_col��
		for (int r=0; r<nA_row; r++) //Mtrx_c�� �� ���Ҹ� 0��~nA_row-1�� ������ ���ʴ�� ���� ����
		{
			for (int c=0; c<nB_col; c++) 
			{
				Mtrx_c[r][c] = 0; //�ش� ��ġ�� ���Ҹ� ���� 0���� ����
				for (int k=0; k<nA_col; k++) 
				{
					//����� ���� �Ŀ� ���� ���
					Mtrx_c[r][c] += mA_data[r][k] * mB_data[k][c];
				}
			}
		}
		return Mtrx_c; //mA�� mB����� ���� Mtrx_c����� ��ȯ
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
