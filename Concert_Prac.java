import java.util.Scanner;

class Concert{ //콘서트 예약, 조회, 취소 부분의 클래스 작성

	public static String[] reserve(String seatclass[], String classname) { //S, A, B중 하나의 클래스를 입력받아서 예약받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("[ " + classname + " ]");
		for(int i = 0; i < seatclass.length; i++) //좌석 출력
			System.out.print(" | " + seatclass[i] + " | ");
		
		String name;
		int seatnum;
		
		System.out.print("\n[이름]  >> ");
		name = scanner.next(); 
		while(true) {
			System.out.print("[좌석 번호] >> ");
			seatnum = scanner.nextInt();
			if (seatnum-1 >= seatclass.length || seatnum < 0) {
				System.out.println("없는 좌석번호입니다. 다시 입력하시오");
				continue;
				}
			else {
				if (seatclass[seatnum-1].equals("---")) {
					seatclass[seatnum-1] = name;	//seatnum-1번째 좌석에 이름 입력
					break;
				}			
				else {	//이미 예약되어 있는자리라면 다시 입력받기
					System.out.println("이미 예약되어있는 자리입니다. 다른 번호를 입력하시오.");
					continue;
				}
			}
		}
		return seatclass;
	}
	
	public static String[] cancel(String seatclass[], String classname) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("[ " + classname + " ]");
		for(int i = 0; i < seatclass.length; i++) //좌석 출력
			System.out.print(" | " + seatclass[i] + " | ");
		System.out.println();
		
		String name;
		int index = -1; //이름 인덱스 변수
		
		while(true) { //이름 인덱스 검색, 예약된 이름이 입력될 때까지 반복
			System.out.print("[이름] >>");
			name = scanner.next();
			
			for(int i = 0; i < seatclass.length; i++) { //이름 검색. 이름이 없다면 index = -1
				if(name.equals(seatclass[i]))
						index = i;
			}
			
			if(index == -1) {
				System.out.println("존재하지 않는 이름입니다. 다시 검색하십시오.");
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
		
		int num; //메뉴 선택 변수
		int classnum; //S, A, B석 변수
		String classname[] = {"S", "A", "B"}; //좌석 이름 배열
		
		String seatclass[][] = new String[3][10]; //S, A, B석 생성 [S : [0][], A : [1][], B : [2][]]
		for(int i = 0; i < seatclass.length; i++)
			for(int j = 0; j <seatclass[i].length; j++)
				seatclass[i][j] = "---";
		
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		while(true) {	//프로그램 무한반복, 종료하기(4)를 입력받기 전까지 반복
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("[예약 : 1] [조회 : 2] [취소 : 3] [종료 : 4] >> ");
			num = scanner.nextInt(); //메뉴 선택 정수 입력
			if (num == 1) { //입력 부분
				System.out.print("좌석을 선택하십시오 [S석 : 1] [A석 : 2] [B석 : 3] >> ");
				classnum = scanner.nextInt(); //좌석 선택
				if (classnum-1 >= 3 || classnum < 0) {
					System.out.println("없는 좌석 등급입니다. 다시 입력하시오.");
					continue;
				}
				else {	
					seatclass[classnum-1] = Concert.reserve(seatclass[classnum-1], classname[classnum-1]);
					continue;
				}
			}
			
			else if(num == 2) { //예약된 좌석 조회
				for(int i = 0; i < seatclass.length; i++) {
					System.out.print("[ " + classname[i] + " ]");
					for(int j = 0; j < seatclass[i].length; j++)
						System.out.print(" | " + seatclass[i][j] + " | ");
					System.out.println();
				}
				continue;
			}
			
			else if(num == 3) { //예약 취소하기
				System.out.print("좌석을 선택하십시오 [S석 : 1] [A석 : 2] [B석 : 3] >> ");
				classnum = scanner.nextInt(); //좌석 선택
				if (classnum-1 >= 3 || classnum < 0) {
					System.out.println("없는 좌석 등급입니다. 다시 입력하시오.");
					continue;
				}
				else {	
					seatclass[classnum-1] = Concert.cancel(seatclass[classnum-1], classname[classnum-1]);
					continue;
				}
			}
			
			else if(num == 4) { //프로그램 종료하기
				System.out.println("--- 프로그램을 종료합니다 ---");
				scanner.close();
				break;
			}
			
			else { //없는 메뉴를 입력할 시 다시 입력받음
				System.out.println("존재하지 않는 메뉴입니다. 다시 입력하십시오.");
				continue;
			}
		}
	}
}

/*
 * 1] 3*10 배열을 이용하여 S, A, B석을 생성
 * 
 * 예약부분
 * -S, A, B를 입력받아 클래스에서 수정하여 리턴
 * -잘못된 입력에서는 오류 메시지를 출력하고 다시 입력받기
 * 
 * 조회 부분
 * -반복문를 이용하여 S, A, B전부 출력
 * 
 * 취소 부분
 * -예약부분과 같은 형식으로 취소
 * -클래스 내 반복문을 이용해 이름 찾기 (i = -1로 놓고 이름이 있다면 해당 인덱스 가져와서 이름을 "---"로 바꿈)
 * -없는 이름이라면 다시 입력받기
 * 
 * 
 * 종료
 */