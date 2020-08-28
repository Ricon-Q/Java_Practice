import java.util.Scanner;
class MonthSchedule{
	String work; //할 일
	int menu; //메뉴 선택 
	int day; //날짜 선택
	String schedule[]; //할일
	
	
	public MonthSchedule(int num/*한달에 몇일있는지 입력*/) {
		schedule = new String[num];
		for (int i = 0; i < num; i++) {
			schedule[i] = "---";
		}
	}
	
	public void input() { //할일 입력
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("[날짜 입력] [1 ~ " + schedule.length + "] >> ");
			day = scanner.nextInt();
			
			if(0 < day && day <=schedule.length) {
				System.out.print("[일정 입력] >> ");
				work = scanner.next();
				if(schedule[day-1].equals("---")) {
					schedule[day-1] = work;
					break;
				}
				else { //이미 일정이 있다면 오류 메시지 출력
					System.out.println("이미 일정이 있습니다");
					continue;
				}
			}
			else {	//날짜를 잘못입력했다면 오류 메시지 출력
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
				continue;
			}
		}
		
	}
	
	public void view() { //할일 확인
		System.out.println("이번 달 일정");
		for(int i = 0; i < schedule.length; i++) {
			if((i != 0) && (i % 7 == 0)) { //5일마다 줄바꿈
				System.out.println();
			}
			if (schedule[i].equals("---")) {
				if (i<9) 
					System.out.print("| 0" + (i + 1) + "일 : 일정 없음 |");
				else
					System.out.print("| " + (i + 1) + "일 : 일정 없음 |");
			}
			else
				if (i<9)
					System.out.print("| 0" + (i + 1) + "일 : " + schedule[i] + " |");
				else
					System.out.print("| " + (i + 1) + "일 : " + schedule[i] + " |");
			}
		System.out.println();
	}
	
	
	public void finish() { //프로그램 종료
		System.out.println("---프로그램을 종료합니다---");
	}
	
	public void run() { //메뉴 출력
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("[메뉴 선택]\n[할 일 입력 : 1] [할 일 확인 : 2] [프로그램 종료 : 3] >> ");
			menu = scanner.nextInt();
			
			if(menu == 1) { //할 입 입력
				input();
			}
			else if(menu == 2) { //일정 확인
				view();
			}
			else if(menu == 3) { //프로그램 종료
				finish();
				scanner.close();
				break;
			}
			else { //잘못된 메뉴 입력시 오류문 출력
				System.out.println("잘못된 입력입니다. 다시 입력하십시오");
				continue;
			}
		}	
	}
}
public class Schedule {
	public static void main(String[] args) {
		System.out.println("---이번달 스케쥴 관리 프로그램---");
		MonthSchedule april = new MonthSchedule(30);
		april.run();
	}
}
/*
 * 이번달 스케쥴 관리 시스템
 * 
 * Monthschedule클래스에는 한달에 해당하는 문자열 배열을 생성
 * 
 * 메뉴 입력 
 * 
 * 입력(1)
 * 날짜와 할일을 입력받아서 해당 객체에 저장 (객체배열로 해당 객체를 생성)
 * 
 * 보기(2)
 * 숫자를 입력해서 해당 객체 불러오기
 * 
 * 끝내기(3)
 * break로 반복문 빠져나오기
 */