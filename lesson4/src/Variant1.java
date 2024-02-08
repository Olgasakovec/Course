public class Variant1 {
    public static void main(String[] args) {
        //task1();
        task2();
    }

    public static void task1() {
        /*
        Как получить доступ к переопределенным методам родительского класса?
        Ответ не должен содержать запись new User().
        Менять любые классы запрещено, можно работать только внутри метода task1
        Ответ запишите ниже
        ....
         */
        Task task = new Task();
        task.goTo();
        task.stop();
    }
    public static void task2() {
        /*
        Как получить доступ к переопределенным методам родительского класса?
        Ответ не должен содержать запись new User().
        Менять любые классы запрещено, можно работать только внутри метода task1
        Ответ запишите ниже
        ....
         */

        Flower.Rose rose = new Flower.Rose("Italy", 10, 60.2);
        rose.printFlowerInfo();
        Flower.Gvozdika gvozdika = new Flower.Gvozdika("Paris", 5, 11.5);
        gvozdika.printFlowerInfo();
        Flower.Tulpan tulpan = new Flower.Tulpan("Poland", 9,15.3);
        tulpan.printFlowerInfo();

    }
}

