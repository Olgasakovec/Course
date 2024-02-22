public class Air extends Transport {
    private double wingspan;
    private double runwayLength;

    Air(double power, double maxSpeed, double weight, String brand, double wingspan, double runwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.runwayLength = runwayLength;
    }
    public String getDescription() {
        return String.format(
                "Мощность: %.2f л.с. (%.2f кВ)%nМаксимальная скорость: %.2f км/ч%nМасса: %.2f кг%nМарка: %s%nРазмах крыльев: %.2f м%nМинимальная длина взлетно-посадочной полосы для взлета: %.2f м",
                getPower(), convertPowerToKilowatts(), getMaxSpeed(), getWeight(), getBrand(), wingspan, runwayLength);
    }
}
