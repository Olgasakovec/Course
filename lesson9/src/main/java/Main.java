import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    static void task1() {
        /*
        Убрать все пробелы из переменной text
        Результат вывести в консоль
         */
        String text = " Класс String имеет специальный метод, который позволяет проверить строку на пустоту - isEmpty. ";
        text = text.replaceAll("\\s", "");
        System.out.println(text);
    }

    static void task2() {
        /*
        С помощью регулярных выражений определите есть ли в переменной text спец символы.
         */
        String text = "The Java Virtual Machine is built right into your Java software download, part$ of the JRE and helps run Java applications";
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}:;+]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println("Найдено совпадение: " + text.substring(matcher.start(),matcher.end()));
        }
    }

    static void task3() {
        /*
        Привести все символы параметра text к нижнему регистру.
        Поместить каждое слово параметра text в массив.
        Отсортировать слова в массиве по алфавиту
        Результат вывести в консоль.
         */
        String text = "The Java Runtime Environment is what you get when you download Java software from java.com.";
        text = text.toLowerCase();
        String[] result = text.split("\\s+");
        Arrays.sort(result);

        for (String items : result ) {
            System.out.println(items);
        }
    }
}