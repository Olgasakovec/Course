import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    class Task {
        public static void main(String[] args) {
            task2();
            task3();
        }

        void task1() {
      /*
        Создать класс Product с приватными параметрами name, productId и гетеры/сеттеры для этих параметров.
        Создать динамический массив из объектов Product.
        Массив должен содержать минимум 4 продукта, название для продуктов придумайте сами.
        Изменить productId второго продукт на 0.
        Замените название последнего проекта на название первого проекта.
        С помощью Stream API отфильтровать продукты по условию productId не ровно 0.
        В этой же цепочке вызовов методов выполнить сортировку имени проектов по убыванию.
        В этой же цепочке вызовов методов удалите все дубликаты и выведите каждое имя проекта в обратном порядке.
         */
        }

        static void task2() {
        /*
        Создать динамический массив из объектов Product.
        Массив должен содержать минимум 8 продуктов, название для продуктов придумайте сами.
        Изменить название последних трёх продуктов на название первого продукта.
        С помощью Stream API выполнить группировку по имени проекта и посчитать сумму, минимальное значение, максимальное значение и среднее значение productId для каждой группы.
        Результат вывести в консоль
         */

            List<Product> products = new ArrayList<>();
            products.add(new Product("Product1", 1));
            products.add(new Product("Product2", 2));
            products.add(new Product("Product3", 3));
            products.add(new Product("Product4", 4));
            products.add(new Product("Product5", 5));
            products.add(new Product("Product6", 6));
            products.add(new Product("Product7", 7));
            products.add(new Product("Product8", 8));

            products.get(products.size() - 1).setName(products.get(0).getName());
            products.get(products.size() - 2).setName(products.get(0).getName());
            products.get(products.size() - 3).setName(products.get(0).getName());

            Map<String, IntSummaryStatistics> productsByName = products.stream()
                    .collect(Collectors.groupingBy(Product::getName,
                            Collectors.summarizingInt(Product::getProductId)));

            productsByName.forEach((name, stat) -> {
                System.out.println("Name: " + name);
                System.out.println("Summ: " + stat.getSum());
                System.out.println("Min: " + stat.getMin());
                System.out.println("Max: " + stat.getMax());
                System.out.println("Average: " + stat.getAverage());
            });
        }

        static void task3() {
        /*
        Создать динамический массив из объектов Product.
        Массив должен содержать минимум 4 продукта, название для продуктов придумайте сами.
        С помощью параллельного стрима выполните перемножение productId всех проектов.
        Выполните приведение reduce к числу с результатом через метод get.
        В результате вывести в консоль
         */

            List<Product> products = new ArrayList<>();
            products.add(new Product("Avacado", 1));
            products.add(new Product("Peach", 2));
            products.add(new Product("Mango", 3));
            products.add(new Product("Banana", 4));

            int sum = products.parallelStream()
                    .mapToInt(Product::getProductId)
                    .reduce(1, (x, y) -> x * y);

            System.out.println("Сумма: " + sum);
        }
    }



