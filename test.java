
//다음 클래스들을 조건에 맞게 구현하세요, 필요시 코드를 수정합니다.
abstract class Transportation {
    protected int timeCost;
    public int getTimeCost(){return timeCost;}
    public void setTimeCost(int timeCost){this.timeCost = timeCost;}
    abstract public int computeCost();

    public Transportation() {this.timeCost = 60;}// timeCost를 60으로 초기화 합니다.
    public Transportation(int timeCost){this.timeCost = timeCost;}// timeCost를 입력 받은 값으로 초기화 합니다.
}

class Bus extends Transportation{
    private String busStop;
    private int busFee;
    public String getBusStop() {return this.busStop;} // busStop을 리턴 합니다.
    public void setBusStop(String busStop) { this.busStop = busStop;}// 입력 받은 값으로 busStop의 값을 변경합니다.
    public int getBusFee() {return this.busFee;}//busFee를 리턴 합니다.
    public void setBusFee(int busFee) {this.busFee = busFee;}// 입력받은 값으로 busFee의 값을 변경 합니다.

    public int computeCost() {return this.busFee;}

    public Bus(){
        this.timeCost = 60;
        this.busFee = 1300;
        this.busStop = "국민대학교";
    }
    public Bus(int timeCost, int busFee, String busStop){
        this.timeCost = timeCost;
        this.busFee = busFee;
        this.busStop = busStop;
    }
}

class Subway extends Transportation{
    private String subwayStation;
    private int subwayFee;

    public String getSubwayStation() {return this.subwayStation;}
    public void setSubwayStation(String subwayStation) { this.subwayStation = subwayStation;}
    public int getSubwayFee() {return this.subwayFee; }
    public void setSubwayFee(int subwayFee) {this.subwayFee = subwayFee;}

    public int computeCost(){return this.subwayFee;}

    public Subway(){
        this.timeCost = 60;
        this.subwayFee = 1500;
        this.subwayStation = "길음역";

    } // 기본 생성자는 timeCost를 60, subwayFee를 1500, subwayStation을 길음역 으로 초기화 합니다.
    public Subway(int timeCost, int subwayFee, String subwayStation){
        this.timeCost = timeCost;
        this.subwayFee = subwayFee;
        this.subwayStation = subwayStation;
    } // 멤버 변수를 각각 입력 받은 값을 초기화 합니다.
}

class Car extends Transportation{
    private int gas;
    public int getGas(){return this.gas;}
    public void setGas(int gas){this.gas = gas;}

    public Car() {
        this.timeCost = 60;
        this.gas = 0;
    }//기본 생성자는 timeCost를 60으로, gas를 0 으로 초기화 합니다.
    public Car(int timeCost, int gas) {
        this.timeCost = timeCost;
        this.gas = gas;
    }// 입력 받은 값으로 멤버 변수의 값을 초기화 합니다.
    public int computeCost() {return 0;}
}

// 메소드 solution()의 코드는 변경하지 않고, 메소드 computeTotalCost()를 조건에맞게 구현하세요.
class Solution {
    public int solution(int ignore) {
        int answer = 0;
        return answer;
    }
    public int computeTotalCost(Transportation[] transports) {
        int totalCost = 0;
        int k;
        for(int i = 0; i < 3; i++){
            if(transports[i] instanceof Car){
                if((Car)transports[i].getGas() <= 0) {
                    totalCost += 50000;
                    continue;
                }
                totalCost += (Car)transports[i].computeCost();
            }
            else if(transports[i] instanceof Bus){
                totalCost += (Bus)transports[i].computeCost();
            }
            else if(transports[i] instanceof Subway){
                totalCost += (Subway)transports[i].computeCost();
            }
        }

        return totalCost;

    }
}