public class Buket {
    private Flower[] flowers;
    public Buket(Flower[] flowers) {
        this.flowers = flowers;
    }
    public double getSellFlowers() {
        double totalPrice;
        for (Flower flower : flowers) {
            totalPrice += flower.getPrice();
        }
        return totalPrice;
    }
    public void sell() {
        int count = flowers.length;
        Flower.sellCount += count;
   }

}
