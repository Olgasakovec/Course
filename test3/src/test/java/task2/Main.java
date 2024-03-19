package task2;
public class Main {
    public static void main(String[] args) {
        Trouthers myPants =  new Pants();
        Shooes myHeels = new Heels();
        Jacket myJacket = new Jamper();

        Person coolPerson = new Person("Peter", myPants, myHeels, myJacket);
        coolPerson.takeoff();
        coolPerson.takeon();
    }
}
