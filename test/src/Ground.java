public class Ground extends Transport{
    private int wheelCount;
    private double fuelСonsumption;

       Ground(double power, double maxspeed, double weight, String brand, int wheelCount, double fuelСonsumption){
        super(power, maxspeed, weight, brand);
        this.fuelСonsumption = fuelСonsumption;
        this.wheelCount = wheelCount;

    }


    public String getDescription() {
        return String.format("Мощность: %.2f л.с. (%.2f кВ)%nМаксимальная скорость: %.2f км/ч%nМасса: %.2f кг%nМарка: %s%nКоличество колес: %d%nРасход топлива: %.2f л/100км",
                getPower(), convertPowerToKilowatts(), getMaxSpeed(), getWeight(), getBrand(), wheelCount, fuelСonsumption);
    }
 }
