public class Task {
    public static void main(String[] args) {
        task1();
    }
    public static void task1();{

    /*
        Как получить доступ к переопределенным методам родительского класса?
        Ответ не должен содержать запись new User().
        Менять любые классы запрещено, можно работать только внутри метода task1
        Ответ запишите ниже
        ....
         */
        public class Task extends User {

            @Override
            public void stop() {
                super.stop();
                System.out.println("stop method is override");
            }

            @Override
            public void goTo() {
                super.goTo();
                System.out.println("goTo method is override");
            }
        }
    }
}
