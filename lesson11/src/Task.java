public class Task {

    public static void main(String[] args) {
        task1();
    }

    static void task1() {
        /*
         Определить реализацию метода IFunction интерфейса с использованием lambda-выражения.
         В реализации метода должно быть соединение первой переменной с второй через метод join
         и результат должен быть возвращаён перевёрнытм задом наперёд.
         Результат вывести в консоль.
         */

        IFunctional revert = (x, y) -> {
            String joinValue = String.join(" ", x, y);
            return new StringBuilder(joinValue).reverse().toString();
        };

        String text1 = "Hello";
        String text2 = "Java";

        String result = revert.getResult(text1, text2);

        System.out.println(result);


    }

    static void task2() {
        /*
        Определить функциональный интерфейс IBox с одним методом double removeBox(Queue<HeavyBox> boxes);

        Создать очередь, содержащую объекты класса HeavyBox.
        Используем класс PriorityQueue и интерфейс Queue.
        Поместить объекты в очередь с помощью метода offer().

        Определить реализацию метода removeBox интерфейса IBox с использованием lambda-выражения.
        Реализация должна удалить все объекты методом poll().
         */
    }

    static void task3() {
    /*
        Создать динамический массив HeavyBox, в котором будут HeavyBox весами, 200, 300, 400 и 2500.
        Создать просто одиночный объект класса HeavyBox у которого будет вес 2200.
        Создать фуконцию, которая принимает в качестве параметра два объекта типа HeavyBox через BinaryOperator.
        Функция выполняет сравнение веса первого HeavyBox с весом второго HeavyBox.
        Если вес первого HeavyBox больше веса второго HeavyBox, то вернуть первый HeavyBox, если нет вернуть второй HeavyBox
        Запустить BinaryOperator для каждого элемента динамического массива.
        Каждый элемент массива надо сравнивать с одиночным объектом класса HeavyBox, который вы самом начале.
         */
    }

}
