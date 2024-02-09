public class Main2 {
    public static void main(String[] args) {
        flower();
    }

    /*
            Создать класс Flower, который содержит переменные страна производитель, срок хранения в днях, цена.
            Создать классы расширяющие класс Flower (для примера, пусть это будут розы, гвоздики, тюльпаны и... что-то на свой вкус).
            Собрать 3 букета (используем массив) с определением их стоимости.
            В букет может входить несколько цветов разного типа.
            Также подсчитать количество проданных цветов (используем статическую переменную).
             */
    public static void flower() {
        Rose rose = new Rose("Germany", 10, 22);
        Gvozdika gvozdika = new Gvozdika("Italy", 9, 7.5);
        Tulpan tulpan = new Tulpan("Paris", 8, 5.5);

        Flower[] flowers1 = new Flower[]{rose, gvozdika, tulpan, tulpan, tulpan};
        Flower[] flowers2 = new Flower[]{rose, rose, rose, rose};
        Flower[] flowers3 = new Flower[]{tulpan, tulpan, tulpan};

        Buket buket1 = new Buket(flowers1);
        Buket buket2 = new Buket(flowers2);
        Buket buket3 = new Buket(flowers3);

        buket1.sell();
        buket2.sell();
        rose.sell();

        System.out.println("Букет 1: " + buket1.getSellFlowers());
        System.out.println("Букет 2: " + buket2.getSellFlowers());
        System.out.println("Букет 3: " + buket3.getSellFlowers());
        System.out.println("Total sell flowers: " + Flower.sellCount);
    }
}

