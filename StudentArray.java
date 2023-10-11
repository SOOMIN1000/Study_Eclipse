import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class StudentArray {
	Student[] students;
	int num_students;
	StudentArray()//기본 생성자
	{
		num_students=0;
		this.students=new Student[num_students];
	}	
	
	public void fget_students(Scanner fin)
	{
		num_students=fin.nextInt(); //먼저 학생 수를 읽고
		this.students=new Student[num_students];//해당 크기만큼의 학생 배열을 만듬
				
		for(int i=0;i<num_students;i++)//1번째 학생의 정보를 다 입력,2번째 입력,3번째...반복
		{
			//모든 정보를 읽어서 변수에 넣고 해당 변수로 i번째 학생 객체를 설정
			String name=fin.next();
			int reg_id=fin.nextInt();
			int st_id=fin.nextInt();
			String dept=fin.next();
			String school=fin.next();
			double GPA=fin.nextDouble();
			this.students[i]=new Student(name,reg_id,st_id,dept,school,GPA);
		}
	}
	
	public void print_students() {
		//Student 객체의 정보를 console에 출력 (toString이용)
		System.out.println("Total "+num_students+" students : ");
		for(int i=0;i<num_students;i++)
		System.out.print(students[i]);
	}
	
	
	public void fprint_students(FileWriter fout)throws IOException
	{
		//Student객체의 정보를 file에 출력함 (toString을 이용)
		fout.write("Total "+num_students+"students : \n");
		for(int i=0;i<num_students;i++)
		{
			
			fout.write(String.format("%s",students[i]));
		}
		
	}
	
	public void sort(String key_attr,String sorting_order)
	{
		//삽입 정렬(compareStudent를 이용하여 key_attr의 값을 비교함)
		int i,j;
		Student temp_st;
		for(i=1;i<num_students;i++)
		{
			temp_st=students[i];
			for(j=i-1;j>=0 &&students[j].compareStudent(key_attr,temp_st)==1;j--)
			{
				students[j+1]=students[j];
			}
			students[j+1]=temp_st;
		}
		
		
		if(sorting_order=="decreasing") //내림차순이라면 거꾸로
		{
			Student[] temp=new Student[num_students];
			j=num_students;
			for(i=0;i<num_students;i++)
			{
				temp[i]=students[j-1];
				j--;
			}
			
			for(i=0;i<num_students;i++)
			{
				students[i]=temp[i];
			}
		}
		
	}

	
	
	
}
