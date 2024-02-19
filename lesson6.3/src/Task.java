public class Task {
    private String[] stringTicket;

    public static void main (String[]args){
        task2();
        task3();
}
    void task1() {
        /*
        В файле Тема4-Исключения.docx лежит задание по исключениям.
         */
    }

     static void task2(){}
             //Почему нельзя получить элемент из списка ниже?

            /*public static <T> T getFirst(List<? super T> list) {
                return list.get(0);
                Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object
                public static <T> Object getFirst(List<? super T> list) {
        return list.get(0);
             */

    static void task3() {
        /*
        В системе есть пользователь, пусть это будет класс User.
        Добавим в систему еще 5 классов, Ticket, TicketBus, TicketCinema, TicketMuseum и TicketTrain
        Система фиксирует место куда пользователь едет по билету и место от куда он едет.
        Вам необходимо модифицировать класс User так, что бы можно было использовать только TicketTrain, Ticket и TicketBus.

        Так же в конструкторе класса User должна быть реализована проверка на null,
         это значение одного или второго параметра конструкторе null, то система должна выкинуть кастомный эксепшен с текстом 'Билет не может быть null'

        Как видно из примера ниже, можно установить любые классы
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        User user = new User(new TicketCinema(), ticket2);
         */

        TicketBus ticket1 = new TicketBus();
        TicketTrain ticket2 = new TicketTrain();
        try {
            User user = new <TicketTransport>User(ticket1, ticket2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}