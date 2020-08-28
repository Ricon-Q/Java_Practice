import java.util.Scanner;
class MonthSchedule{
	String work; //�� ��
	int menu; //�޴� ���� 
	int day; //��¥ ����
	String schedule[]; //����
	
	
	public MonthSchedule(int num/*�Ѵ޿� �����ִ��� �Է�*/) {
		schedule = new String[num];
		for (int i = 0; i < num; i++) {
			schedule[i] = "---";
		}
	}
	
	public void input() { //���� �Է�
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("[��¥ �Է�] [1 ~ " + schedule.length + "] >> ");
			day = scanner.nextInt();
			
			if(0 < day && day <=schedule.length) {
				System.out.print("[���� �Է�] >> ");
				work = scanner.next();
				if(schedule[day-1].equals("---")) {
					schedule[day-1] = work;
					break;
				}
				else { //�̹� ������ �ִٸ� ���� �޽��� ���
					System.out.println("�̹� ������ �ֽ��ϴ�");
					continue;
				}
			}
			else {	//��¥�� �߸��Է��ߴٸ� ���� �޽��� ���
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
		
	}
	
	public void view() { //���� Ȯ��
		System.out.println("�̹� �� ����");
		for(int i = 0; i < schedule.length; i++) {
			if((i != 0) && (i % 7 == 0)) { //5�ϸ��� �ٹٲ�
				System.out.println();
			}
			if (schedule[i].equals("---")) {
				if (i<9) 
					System.out.print("| 0" + (i + 1) + "�� : ���� ���� |");
				else
					System.out.print("| " + (i + 1) + "�� : ���� ���� |");
			}
			else
				if (i<9)
					System.out.print("| 0" + (i + 1) + "�� : " + schedule[i] + " |");
				else
					System.out.print("| " + (i + 1) + "�� : " + schedule[i] + " |");
			}
		System.out.println();
	}
	
	
	public void finish() { //���α׷� ����
		System.out.println("---���α׷��� �����մϴ�---");
	}
	
	public void run() { //�޴� ���
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("[�޴� ����]\n[�� �� �Է� : 1] [�� �� Ȯ�� : 2] [���α׷� ���� : 3] >> ");
			menu = scanner.nextInt();
			
			if(menu == 1) { //�� �� �Է�
				input();
			}
			else if(menu == 2) { //���� Ȯ��
				view();
			}
			else if(menu == 3) { //���α׷� ����
				finish();
				scanner.close();
				break;
			}
			else { //�߸��� �޴� �Է½� ������ ���
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��Ͻʽÿ�");
				continue;
			}
		}	
	}
}
public class Schedule {
	public static void main(String[] args) {
		System.out.println("---�̹��� ������ ���� ���α׷�---");
		MonthSchedule april = new MonthSchedule(30);
		april.run();
	}
}
/*
 * �̹��� ������ ���� �ý���
 * 
 * MonthscheduleŬ�������� �Ѵ޿� �ش��ϴ� ���ڿ� �迭�� ����
 * 
 * �޴� �Է� 
 * 
 * �Է�(1)
 * ��¥�� ������ �Է¹޾Ƽ� �ش� ��ü�� ���� (��ü�迭�� �ش� ��ü�� ����)
 * 
 * ����(2)
 * ���ڸ� �Է��ؼ� �ش� ��ü �ҷ�����
 * 
 * ������(3)
 * break�� �ݺ��� ����������
 */