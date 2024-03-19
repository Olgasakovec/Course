public class Military extends Air {
    private boolean hasEjectionSystem;
    private int missileCount;

    public Military(double power, double maxspeed, double weight, String brand, double wingspan, double runwayLength, boolean hasEjectionSystem, int missileCount) {
        super(power, maxspeed, weight, brand, wingspan, runwayLength);
        this.hasEjectionSystem = hasEjectionSystem;
        this.missileCount = missileCount;
    }
    public String getDescription() {
        return super.getDescription() + String.format("hasEjectionSystem is %s missileCount is %s ", hasEjectionSystem, missileCount);
    }
}
