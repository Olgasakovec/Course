/*
        Создать класс Flower, который содержит переменные страна производитель, срок хранения в днях, цена.
        Создать классы расширяющие класс Flower (для примера, пусть это будут розы, гвоздики, тюльпаны и... что-то на свой вкус).
        Собрать 3 букета (используем массив) с определением их стоимости.
        В букет может входить несколько цветов разного типа.
        Также подсчитать количество проданных цветов (используем статическую переменную).
         */
public class Flower {

    private String countryOfOrigin;
    private int storageDays;
    public double price;

    public Flower(String countryOfOrigin, int storageDays, double price) {
        this.countryOfOrigin = countryOfOrigin;
        this.storageDays = storageDays;
        this.price = price;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printFlowerInfo() {
    }

    public static class Rose extends Flower {
        public Rose(String countryOfOrigin, int storageDays, double price) {
            super(countryOfOrigin, storageDays, price);
        }
    }
    public class Gvozdika extends Flower {
        public Gvozdika(String countryOfOrigin, int storageDays, double price) {
            super(countryOfOrigin, storageDays, price);
        }
    }
    public class Tulpan extends Flower {
        public Tulpan(String countryOfOrigin, int storageDays, double price) {
            super(countryOfOrigin, storageDays, price);
        }
    }



}



