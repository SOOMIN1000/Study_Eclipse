/*
 * 파일명: "Homework4_1"
 * 프로그램의목적및기본기능: 
 *  -클래스의 상속을 이해하고 interface를 이용하여 관리하고 간단하게 테스트
 *   해보는 프로그램 (자동차라는 상위 클래스와 자동차의 종류를 하위 클래스로
 *   하여 테스트)
 * 프로그램작성자: 천수민(2023년10월8일)
 * 최종Update : 2023년10월8일
 * =========================================================
 * 프로그램수정/보완이력
 * =========================================================
 * 프로그램수정/보완		작업자일자		수정/보완내용
 * 천수민				2023/10/8	interface와 각 class를 구현하고 
 *                              test 부분 (App)을 구현함
 * */
public class App_Vehicle_Sedan_Bus_Truck {//프로그램의 테스트 부분
	public static void main(String[] args) {
		Person[] drivers = {new Person("Kim", 11111), 
		new Person("Park", 22222), new Person("Choi", 33333)};
		Vehicle[] vehicles = {
		new Sedan("Red", "SUV", 3000, drivers[0], 5), 
		new bus("Yellow", "CityBus", 50000, drivers[1], 50),
		new Truck("Black", "CagoTruck", 100000, drivers[2], 200)
		};
		System.out.print("Vehicles : ");
		for (Vehicle v : vehicles) {
		System.out.print(v);
		if (v != vehicles[vehicles.length -1])
		System.out.print(", "); }
		System.out.println();
		System.out.println("\nDriving of Vehicles :");
		for (Vehicle v : vehicles) {
		System.out.printf("%s :: ", v);
		v.forward(100);
		v.turn(90);
		v.stop(); 
		} 
	}
}
