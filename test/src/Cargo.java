public class Cargo extends Ground {
    private double carryingCapacity;

    public Cargo(double power, double maxSpeed, double weight, String brand, int wheelCount, double fuelConsumption, double carryingCapacity) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.carryingCapacity = carryingCapacity;

    }
        public double getCarryingCapacity() {
            return carryingCapacity;
        }

        public String get.Description(){
        return super.getDescription() + carryingCapacity;
    }

}
