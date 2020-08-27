import java.util.Scanner;

class Concert{ //�ܼ�Ʈ ����, ��ȸ, ��� �κ��� Ŭ���� �ۼ�

	public static String[] reserve(String seatclass[], String classname) { //S, A, B�� �ϳ��� Ŭ������ �Է¹޾Ƽ� �������
		Scanner scanner = new Scanner(System.in);
		System.out.print("[ " + classname + " ]");
		for(int i = 0; i < seatclass.length; i++) //�¼� ���
			System.out.print(" | " + seatclass[i] + " | ");
		
		String name;
		int seatnum;
		
		System.out.print("\n[�̸�]  >> ");
		name = scanner.next(); 
		while(true) {
			System.out.print("[�¼� ��ȣ] >> ");
			seatnum = scanner.nextInt();
			if (seatnum-1 >= seatclass.length || seatnum < 0) {
				System.out.println("���� �¼���ȣ�Դϴ�. �ٽ� �Է��Ͻÿ�");
				continue;
				}
			else {
				if (seatclass[seatnum-1].equals("---")) {
					seatclass[seatnum-1] = name;	//seatnum-1��° �¼��� �̸� �Է�
					break;
				}			
				else {	//�̹� ����Ǿ� �ִ��ڸ���� �ٽ� �Է¹ޱ�
					System.out.println("�̹� ����Ǿ��ִ� �ڸ��Դϴ�. �ٸ� ��ȣ�� �Է��Ͻÿ�.");
					continue;
				}
			}
		}
		return seatclass;
	}
	
	public static String[] cancel(String seatclass[], String classname) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("[ " + classname + " ]");
		for(int i = 0; i < seatclass.length; i++) //�¼� ���
			System.out.print(" | " + seatclass[i] + " | ");
		System.out.println();
		
		String name;
		int index = -1; //�̸� �ε��� ����
		
		while(true) { //�̸� �ε��� �˻�, ����� �̸��� �Էµ� ������ �ݺ�
			System.out.print("[�̸�] >>");
			name = scanner.next();
			
			for(int i = 0; i < seatclass.length; i++) { //�̸� �˻�. �̸��� ���ٸ� index = -1
				if(name.equals(seatclass[i]))
						index = i;
			}
			
			if(index == -1) {
				System.out.println("�������� �ʴ� �̸��Դϴ�. �ٽ� �˻��Ͻʽÿ�.");
				continue;
			}
			else {
				seatclass[index] = "---";
				break;
			}
		}
		return seatclass;
	}
	
}

public class Concert_Prac {
	public static void main(String[] args) {
		
		int num; //�޴� ���� ����
		int classnum; //S, A, B�� ����
		String classname[] = {"S", "A", "B"}; //�¼� �̸� �迭
		
		String seatclass[][] = new String[3][10]; //S, A, B�� ���� [S : [0][], A : [1][], B : [2][]]
		for(int i = 0; i < seatclass.length; i++)
			for(int j = 0; j <seatclass[i].length; j++)
				seatclass[i][j] = "---";
		
		System.out.println("��ǰ�ܼ�ƮȦ ���� �ý����Դϴ�.");
		while(true) {	//���α׷� ���ѹݺ�, �����ϱ�(4)�� �Է¹ޱ� ������ �ݺ�
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("[���� : 1] [��ȸ : 2] [��� : 3] [���� : 4] >> ");
			num = scanner.nextInt(); //�޴� ���� ���� �Է�
			if (num == 1) { //�Է� �κ�
				System.out.print("�¼��� �����Ͻʽÿ� [S�� : 1] [A�� : 2] [B�� : 3] >> ");
				classnum = scanner.nextInt(); //�¼� ����
				if (classnum-1 >= 3 || classnum < 0) {
					System.out.println("���� �¼� ����Դϴ�. �ٽ� �Է��Ͻÿ�.");
					continue;
				}
				else {	
					seatclass[classnum-1] = Concert.reserve(seatclass[classnum-1], classname[classnum-1]);
					continue;
				}
			}
			
			else if(num == 2) { //����� �¼� ��ȸ
				for(int i = 0; i < seatclass.length; i++) {
					System.out.print("[ " + classname[i] + " ]");
					for(int j = 0; j < seatclass[i].length; j++)
						System.out.print(" | " + seatclass[i][j] + " | ");
					System.out.println();
				}
				continue;
			}
			
			else if(num == 3) { //���� ����ϱ�
				System.out.print("�¼��� �����Ͻʽÿ� [S�� : 1] [A�� : 2] [B�� : 3] >> ");
				classnum = scanner.nextInt(); //�¼� ����
				if (classnum-1 >= 3 || classnum < 0) {
					System.out.println("���� �¼� ����Դϴ�. �ٽ� �Է��Ͻÿ�.");
					continue;
				}
				else {	
					seatclass[classnum-1] = Concert.cancel(seatclass[classnum-1], classname[classnum-1]);
					continue;
				}
			}
			
			else if(num == 4) { //���α׷� �����ϱ�
				System.out.println("--- ���α׷��� �����մϴ� ---");
				scanner.close();
				break;
			}
			
			else { //���� �޴��� �Է��� �� �ٽ� �Է¹���
				System.out.println("�������� �ʴ� �޴��Դϴ�. �ٽ� �Է��Ͻʽÿ�.");
				continue;
			}
		}
	}
}

/*
 * 1] 3*10 �迭�� �̿��Ͽ� S, A, B���� ����
 * 
 * ����κ�
 * -S, A, B�� �Է¹޾� Ŭ�������� �����Ͽ� ����
 * -�߸��� �Է¿����� ���� �޽����� ����ϰ� �ٽ� �Է¹ޱ�
 * 
 * ��ȸ �κ�
 * -�ݺ����� �̿��Ͽ� S, A, B���� ���
 * 
 * ��� �κ�
 * -����κа� ���� �������� ���
 * -Ŭ���� �� �ݺ����� �̿��� �̸� ã�� (i = -1�� ���� �̸��� �ִٸ� �ش� �ε��� �����ͼ� �̸��� "---"�� �ٲ�)
 * -���� �̸��̶�� �ٽ� �Է¹ޱ�
 * 
 * 
 * ����
 */