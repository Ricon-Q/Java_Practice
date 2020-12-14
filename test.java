
//���� Ŭ�������� ���ǿ� �°� �����ϼ���, �ʿ�� �ڵ带 �����մϴ�.
abstract class Transportation {
    protected int timeCost;
    public int getTimeCost(){return timeCost;}
    public void setTimeCost(int timeCost){this.timeCost = timeCost;}
    abstract public int computeCost();

    public Transportation() {this.timeCost = 60;}// timeCost�� 60���� �ʱ�ȭ �մϴ�.
    public Transportation(int timeCost){this.timeCost = timeCost;}// timeCost�� �Է� ���� ������ �ʱ�ȭ �մϴ�.
}

class Bus extends Transportation{
    private String busStop;
    private int busFee;
    public String getBusStop() {return this.busStop;} // busStop�� ���� �մϴ�.
    public void setBusStop(String busStop) { this.busStop = busStop;}// �Է� ���� ������ busStop�� ���� �����մϴ�.
    public int getBusFee() {return this.busFee;}//busFee�� ���� �մϴ�.
    public void setBusFee(int busFee) {this.busFee = busFee;}// �Է¹��� ������ busFee�� ���� ���� �մϴ�.

    public int computeCost() {return this.busFee;}

    public Bus(){
        this.timeCost = 60;
        this.busFee = 1300;
        this.busStop = "���δ��б�";
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
        this.subwayStation = "������";

    } // �⺻ �����ڴ� timeCost�� 60, subwayFee�� 1500, subwayStation�� ������ ���� �ʱ�ȭ �մϴ�.
    public Subway(int timeCost, int subwayFee, String subwayStation){
        this.timeCost = timeCost;
        this.subwayFee = subwayFee;
        this.subwayStation = subwayStation;
    } // ��� ������ ���� �Է� ���� ���� �ʱ�ȭ �մϴ�.
}

class Car extends Transportation{
    private int gas;
    public int getGas(){return this.gas;}
    public void setGas(int gas){this.gas = gas;}

    public Car() {
        this.timeCost = 60;
        this.gas = 0;
    }//�⺻ �����ڴ� timeCost�� 60����, gas�� 0 ���� �ʱ�ȭ �մϴ�.
    public Car(int timeCost, int gas) {
        this.timeCost = timeCost;
        this.gas = gas;
    }// �Է� ���� ������ ��� ������ ���� �ʱ�ȭ �մϴ�.
    public int computeCost() {return 0;}
}

// �޼ҵ� solution()�� �ڵ�� �������� �ʰ�, �޼ҵ� computeTotalCost()�� ���ǿ��°� �����ϼ���.
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