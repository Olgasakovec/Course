public class Civil extends Air {
    private int passengerCount;
    private boolean hasBusinessClass;
    private double maxPassengerCount;
    private double passengerCountLoad;


    public Civil(double power, double maxSpeed, double weight, String brand, double wingspan, double runwayLength, int passengerCount, boolean hasBusinessClass, double maxPassengerCount, double passengerCountLoad){
        super(power, maxSpeed, weight, brand, wingspan, runwayLength);
        this.passengerCount = passengerCount;
        this.hasBusinessClass = hasBusinessClass;
        this.maxPassengerCount = maxPassengerCount;
        this.passengerCountLoad = passengerCountLoad;
    }

    public void info() {
        if (this.passengerCountLoad <= maxPassengerCount) {
            System.out.println("Автобус загружен");
        } else {
            System.out.println("Вам нужен автобус побольше");
        }
    }

    public String getDescription() {
        return super.getDescription() + String.format("passengerCount is %s, hasBusinessClass is %s", passengerCount, hasBusinessClass);
    }


}

