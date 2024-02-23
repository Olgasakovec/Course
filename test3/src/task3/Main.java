package task3;

public class Main {
    public static void main (String []args){
        Cosmodrom cosmodrom = new Cosmodrom();
        Shatl shatl = new Shatl();
        SpaceX spaceX = new SpaceX();

        cosmodrom.star(shatl);
        cosmodrom.star(spaceX);
    }


}
