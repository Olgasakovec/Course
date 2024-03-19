public class Cargo extends Ground {
<<<<<<< HEAD
    private double carryingCapacity;
=======
    private final double carryingCapacity;
>>>>>>> main

    public Cargo(double power, double maxSpeed, double weight, String brand, int wheelCount, double fuelConsumption, double carryingCapacity) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.carryingCapacity = carryingCapacity;

    }
<<<<<<< HEAD
        public double getCarryingCapacity() {
            return carryingCapacity;
        }

        public String get.Description(){
=======

        public String getDescription(){
>>>>>>> main
        return super.getDescription() + carryingCapacity;
    }

}
