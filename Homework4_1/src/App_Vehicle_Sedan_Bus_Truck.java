/*
 * ���ϸ�: "Homework4_1"
 * ���α׷��Ǹ����ױ⺻���: 
 *  -Ŭ������ ����� �����ϰ� interface�� �̿��Ͽ� �����ϰ� �����ϰ� �׽�Ʈ
 *   �غ��� ���α׷� (�ڵ������ ���� Ŭ������ �ڵ����� ������ ���� Ŭ������
 *   �Ͽ� �׽�Ʈ)
 * ���α׷��ۼ���: õ����(2023��10��8��)
 * ����Update : 2023��10��8��
 * =========================================================
 * ���α׷�����/�����̷�
 * =========================================================
 * ���α׷�����/����		�۾�������		����/���ϳ���
 * õ����				2023/10/8	interface�� �� class�� �����ϰ� 
 *                              test �κ� (App)�� ������
 * */
public class App_Vehicle_Sedan_Bus_Truck {//���α׷��� �׽�Ʈ �κ�
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
