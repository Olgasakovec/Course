//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        task1();
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
}
