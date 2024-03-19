public class Transport {
<<<<<<< HEAD
    private double power;
    private double maxSpeed;
    private double weight;
    private String brand;

    public Transport (double power, double maxSpeed, double weight, String brand){
=======
    public Transport() {

    }

    public static void main(String[] args) {

    }

    private double power;
    public double maxSpeed;
    private double weight;
    private String brand;


    public Transport(double power, double maxSpeed, double weight, String brand) {
>>>>>>> main
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }
<<<<<<< HEAD
    public double getPower(){
        return power;
    }
=======

    public double getPower() {
        return power;
    }

>>>>>>> main
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

<<<<<<< HEAD
    public double convertPowerToKilowatts(){
        return getPower() * 0.74;
    }
}
=======
    public double convertPowerToKilowatts() {
        return getPower() * 0.74;
    }

    private double calculateFuelConsumption(double distance) {
        double fuelСonsumption = (fuelСonsumption / 100) * distance;
        return fuelСonsumption;
    }

    public double calculatedDistance(double time) {
        double distance = maxSpeed * (time / 60.0);
        return distance;
    }


    public void calculatedDistanceFuelfuelСonsumption(double time) {
        double distance = calculatedDistance(time);
        double fuelConsumed = calculateFuelConsumption(distance);
        System.out.println("За время" + time + "ч" + "автомобиль" + brand + "двигаясь с максимальной скоростью" + maxSpeed + "км/ч проедет" + distance + "км" + "и израсходует" + fuelConsumed + "литров топлива");
    }

}

>>>>>>> main
