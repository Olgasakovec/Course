public enum Seasons {
    Spring,
    Summer,
    Autumn,
    Winter;

    public int getDays() {
        switch (this) {
            case Spring:
                return  92;
            case Summer:
                return  90;
            case Autumn:
                return  93;
            case Winter:
                return 89;
            default:
                return 0;
        }
    }
}
