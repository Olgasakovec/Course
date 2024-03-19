package clothes;
public abstract class Clothe {
    private int sizeWear;
    private double costWear;
    private String colorWear;
    public Clothe(int sizeWear, int costWear, String colorWear){
        this.sizeWear = sizeWear;
        this.costWear = costWear;
        this.colorWear = colorWear;
    }

    public int getSizeWear(){
        return sizeWear;
    }

    public double getCostWear(){
        return costWear;
    }

    public String getColorWear() {
        return colorWear;
    }
}