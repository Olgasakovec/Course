public enum SizeEnum {
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    SizeEnum(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return this.euroSize;
    }

    public void getDescription() {

        switch (this) {
            case XXS: {
                System.out.println("Детский размер");
                break;
            }
            default: System.out.println("Взрослый размер");
        }
    }
}
