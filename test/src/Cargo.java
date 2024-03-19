public class Cargo extends Ground {
    private final double carryingCapacity;

    public Cargo(double power, double maxSpeed, double weight, String brand, int wheelCount, double fuelConsumption, double carryingCapacity) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.carryingCapacity = carryingCapacity;

    }

        public String getDescription(){
        return super.getDescription() + carryingCapacity;
    }

}
