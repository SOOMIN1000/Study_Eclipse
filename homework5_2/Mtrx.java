import java.util.Scanner;
import java.io.*;

public class Mtrx {
	String m_name; //행렬의 이름
	int n_row; //행이 크기
	int n_col; //열의 크기
	double[][] m_data; //각 원소
	Mtrx(){}//기본 생성자
	Mtrx(String nm){ //이름만 인자로 받아옴
		m_name=nm;
	}
	Mtrx(String nm,int n_row,int n_col) //이름, 행, 열의 크기 까지 받아옴
	{
		m_name=nm;
		this.n_row=n_row;
		this.n_col=n_col;
		m_data=new double[n_row][n_col];
	}
	Mtrx(String nm,int n_row,int n_col,double[][] m_data)//이름,행,열,원소의 정보까지 다 받아옴
	{
		m_name=nm;
		this.n_row=n_row;
		this.n_col=n_col;
		this.m_data=new double[n_row][n_col];
		for(int i=0;i<n_row;i++)
		{
			for(int j=0;j<n_col;j++)
			{
				this.m_data[i][j]=m_data[i][j];
			}
		}
		
	}
	
	 public static Mtrx fget_Mtrx(Scanner fin) 
	 {
		//static으로 선언되어서 객체가 생성되기 전에 실행되기 때문에
		//변수를 생성해서 그 변수에 읽어온 값을 다 넣고 그 값들로 객체를 생성해줌
		String name=fin.next();
		int row=fin.nextInt();
		int col=fin.nextInt();
		double[][] mtrx=new double[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++) {
				mtrx[i][j]=fin.nextDouble();
				}
		}
		
		Mtrx A=new Mtrx(name,row,col,mtrx); //읽어온 정보로 객체 생성 후 반환
		return A;
		
	 }
	 
	 public void setMtrxName(String nm)//행렬의 이름을 바꿔주는 역할
	 {
		 this.m_name=nm;
	 }
	 
	 public void printMtrx()//행렬의 출력 (console)
	 {
		 System.out.printf("%s (%d x %d) = \n",m_name,n_row,n_col);
		 for (int i=0; i<this.n_row; i++) {
			 for (int j=0; j<this.n_col; j++) {
			 System.out.printf("%7.2f", this.m_data[i][j]); }
			 System.out.printf("\n"); }
		 
	 }
	 
	 public void fprintMtrx(FileWriter fout) throws IOException
	 {
		 //행렬의 출력 (파일)
		 fout.write(this.m_name+" ("+this.n_row+" x "+this.n_col+") = \n");
		 //이름 (행크기 x 열크기) = 의 식으로 fout.write을 통해 파일 출력
		 for(int i=0;i<n_row;i++)
		 {
			 for(int j=0;j<n_col;j++)
			 {
				String str=String.format("%7.2f  ", m_data[i][j]);
				fout.write(str);
			 }
			 fout.write("\n");//한 행의 출력이 끝나면 개행
		 }
		 fout.flush();
	 }
	 
	 public Mtrx addMtrx(Mtrx other)
	 {
		 //행렬의 덧셈 
		 Mtrx addMtrx=new Mtrx();
		//이름은 아직 정해지지 않음(setname에서 바꿔줄거임)
		 addMtrx.m_name="not defined yet!"; 
		 addMtrx.n_row=this.n_row;
		 addMtrx.n_col=this.n_col;
		 addMtrx.m_data=new double[addMtrx.n_row][addMtrx.n_col];
		 
		 for(int i=0;i<n_row;i++) //각 행과 열이 같은 위치의 원소끼리 더함
		 {
			 for(int j=0;j<n_col;j++)
			 {
				 addMtrx.m_data[i][j]=this.m_data[i][j]+other.m_data[i][j];
			 }
		 }
		 //Mtrx 객체를 만들어서 해당 객체의 정보를 덧셈한 행렬로 갱신 후 반환
		 return addMtrx;
		 
	 }
	 
	 public Mtrx subMtrx(Mtrx other)
	 {
		 Mtrx subMtrx=new Mtrx();
		//이름은 아직 정해지지 않음(setname에서 바꿔줄거임)
		 subMtrx.m_name="not defined yet!";
		 subMtrx.n_row=this.n_row;
		 subMtrx.n_col=this.n_col;
		 subMtrx.m_data=new double[subMtrx.n_row][subMtrx.n_col];
		 
		 for(int i=0;i<n_row;i++) //각 행과 열이 같은 위치의 원소끼리 뺌
		 {
			 for(int j=0;j<n_col;j++)
			 {
				 subMtrx.m_data[i][j]=this.m_data[i][j]-other.m_data[i][j];
			 }
		 }
		 //Mtrx 객체를 만들어서 해당 객체의 정보를 덧셈한 행렬로 갱신 후 반환
		 return subMtrx;
	 }
	 
	 public Mtrx mulMtrx(Mtrx other)
	 {
		 Mtrx mulMtrx=new Mtrx();
		//이름은 아직 정해지지 않음(setname에서 바꿔줄거임)
		 mulMtrx.m_name="not defined yet!";
		 mulMtrx.n_row=this.n_row;//곱하면 앞 행렬의 행의 크기
		 mulMtrx.n_col=other.n_col;//곱하면 뒷 행렬의 열의 크기
		 mulMtrx.m_data=new double[mulMtrx.n_row][mulMtrx.n_col];
		 double temp_sum;
		 
		 for(int i=0;i<this.n_row;i++) //행렬의 곱셈 방식을 반복문으로 구현
		 {
			 for(int j=0;j<other.n_col;j++)
			 {
				 temp_sum=0.0;
				 for(int k=0;k<this.n_col;k++)
				 {
					 temp_sum+=this.m_data[i][k]*other.m_data[k][j];
				 }
				 mulMtrx.m_data[i][j]=temp_sum;
			 }
		 }
		 
		 //Mtrx 객체를 만들어서 해당 객체의 정보를 덧셈한 행렬로 갱신 후 반환
		 return mulMtrx;
	 }
	 
}

