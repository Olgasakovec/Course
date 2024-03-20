public class PassengerCar extends Ground {
    private String bodyType;
    private int passengerCount;

    public PassengerCar(double power, double maxSpeed, double weight, String brand, int wheelCount, double fuelConsumption, String bodyType, int passengerCount) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.bodyType = bodyType;
        this.passengerCount = passengerCount;
    }

    public String getDescription() {
        return super.getDescription() + String.format("bodyType is %s, passengerCount is %s", bodyType, passengerCount);
    }
}
