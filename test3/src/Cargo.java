public class Cargo extends Ground {
    private double carryingCapacity;

    private double cargoWeightLoad;

    public String getDescription() {
        return super.getDescription() + carryingCapacity;
    }

    public Cargo(double power, double maxSpeed, double weight, String brand, int wheelCount, double fuelConsumption, double carryingCapacity, double cargoWeightLoad) {
        super(power, maxSpeed, weight, brand, wheelCount, fuelConsumption);
        this.carryingCapacity = carryingCapacity;
        this.cargoWeightLoad = cargoWeightLoad;


        Cargo cargo = new Cargo();
        cargo.carryingCapacity = 10000;
        cargo.cargoWeightLoad = 4000;

        if (cargoWeightLoad <= carryingCapacity) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }

    }
}