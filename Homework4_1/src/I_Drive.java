
public interface I_Drive {//vehicle의 하위 속성에서 공통적으로 사용하는 함수들을 가상으로 정의
	public abstract void forward(int speed); //앞으로 감을 출력
	public abstract void turn(int angle); //몇도를 도는지를 출력
	public abstract void stop(); //멈춤을 출력
}
