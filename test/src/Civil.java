public class Civil extends Air {
    private int passengerCount;
    private boolean hasBusinessClass;


    public Civil(double power, double maxSpeed, double weight, String brand, double wingspan, double runwayLength, int passengerCount, boolean hasBusinessClass){
        super(power, maxSpeed, weight, brand, wingspan, runwayLength);
        this.passengerCount = passengerCount;
        this.hasBusinessClass = hasBusinessClass;
    }
    public String getDescription() {
        return super.getDescription() + String.format("passengerCount is %s, hasBusinessClass is %s", passengerCount, hasBusinessClass);
    }


}
