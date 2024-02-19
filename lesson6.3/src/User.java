public class User {
    private String login;
    private String password;


    <T> User(T ticketTo, T ticketFrom) throws Exception {
        if (ticketTo == null || ticketFrom == null) {
            throw new Exception("Билет не может быть null");
        }

        System.out.println(ticketTo);
        System.out.println(ticketFrom);
    }


}