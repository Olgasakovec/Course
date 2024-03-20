public class Military extends Air {
    private boolean hasEjectionSystem;
    private int missileCount;

    public Military(double power, double maxSpeed, double weight, String brand, double wingspan, double runwayLength, boolean hasEjectionSystem, int missileCount) {
        super(power, maxSpeed, weight, brand, wingspan, runwayLength);
        this.hasEjectionSystem = hasEjectionSystem;
        this.missileCount = missileCount;
    }

    private void shoot() {
        if (this.missileCount != 0) {
            System.out.println("Ракета пошла");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void eject() {
        if (this.hasEjectionSystem) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У вас нет такой системы");
        }
    }

    public String getDescription() {
        return super.getDescription() + String.format("hasEjectionSystem is %s missileCount is %s ", hasEjectionSystem, missileCount);
    }
}
