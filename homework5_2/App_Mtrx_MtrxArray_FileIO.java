/*
 * 파일명: "Homework5_2"
 * 프로그램의목적및기본기능: 
 *  -file 입출력을 이해하고 이를 이용하여 텍스트에 간단한 행렬 정보를 입력 후
 *   이를 읽어와 행렬 객체를 만들고 각 행렬의 덧셈,뺄셈,곱셈을 해보고
 *   결과물을 file과 console로 출력하는 것을 연습해보는 프로그램 
 * 프로그램작성자: 천수민(2023년10월11일)
 * 최종Update : 2023년10월11일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/10/11	파일 입출력을 통한 Mtrx객체 생성 기능,
 *                              각 Mtrx객체의 m_data를 더하고, 빼고,
 *                              곱하는 기능, 테스트 기능 구현
 *                              
 * */

import java.io.*;
import java.util.Scanner;

public class App_Mtrx_MtrxArray_FileIO {
	public static void main(String[] args) throws IOException {
		final String fin_name = "C:\\Users\\PC\\eclipse-workspace\\Homework5_2\\mtrx_data.txt";
		final String fout_name = "C:\\Users\\PC\\eclipse-workspace\\Homework5_2\\mtrx_operation_result.txt";
		Scanner fin = new Scanner(new File(fin_name));
		FileWriter fout = new FileWriter(new File(fout_name));
		Mtrx[] mtrxs = new Mtrx[6];
		mtrxs[0] = Mtrx.fget_Mtrx(fin);
		mtrxs[1] = Mtrx.fget_Mtrx(fin);
		mtrxs[2] = Mtrx.fget_Mtrx(fin);
		mtrxs[0].printMtrx(); mtrxs[0].fprintMtrx(fout);
		mtrxs[1].printMtrx(); mtrxs[1].fprintMtrx(fout);
		mtrxs[2].printMtrx(); mtrxs[2].fprintMtrx(fout);
		mtrxs[3] = mtrxs[0].addMtrx(mtrxs[1]);
		mtrxs[3].setMtrxName("mAdd_AB");
		mtrxs[3].printMtrx(); mtrxs[3].fprintMtrx(fout);
		mtrxs[4] = mtrxs[0].subMtrx(mtrxs[1]);
		mtrxs[4].setMtrxName("mSub_AB");
		mtrxs[4].printMtrx(); mtrxs[4].fprintMtrx(fout);
		mtrxs[5] = mtrxs[0].mulMtrx(mtrxs[2]);
		mtrxs[5].setMtrxName("mMul_AC");
		mtrxs[5].printMtrx(); mtrxs[5].fprintMtrx(fout);
		fout.close();
		} // end main()
}
