public class Ground extends Transport{
    private int wheelCount;
    public double fuelСonsumption;

    Ground(double power, double maxspeed, double weight, String brand, int wheelCount, double fuelСonsumption){
        super(power, maxspeed, weight, brand);
        this.fuelСonsumption = fuelСonsumption;
        this.wheelCount = wheelCount;
    }

    public String getDescription() {
        return String.format("Мощность: %.2f л.с. (%.2f кВ)%nМаксимальная скорость: %.2f км/ч%nМасса: %.2f кг%nМарка: %s%nКоличество колес: %d%nРасход топлива: %.2f л/100км",
                getPower(), convertPowerToKilowatts(), getMaxSpeed(), getWeight(), getBrand(), wheelCount, fuelСonsumption);
    }
    private double calculateFuelConsumption(double distance) {
        return ((fuelСonsumption / 100) * distance / 100) * distance;
    }

    public double calculatedDistance(double time) {
        return maxSpeed * (time / 60.0);
    }

    public void calculatedDistanceFuelfuelСonsumption(double time) {
        double distance = calculatedDistance(time);
        double fuelConsumed = calculateFuelConsumption(distance);
        System.out.println("За время" + time + "ч" + "автомобиль" + getBrand() + "двигаясь с максимальной скоростью" + maxSpeed + "км/ч проедет" + distance + "км" + "и израсходует" + fuelConsumed + "литров топлива");
    }
}
