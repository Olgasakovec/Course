package TASK2;

public class Person {
    private String name;
    private Trouthers trouthers;
    private Shooes shooes;
    private Jacket jacket;

    public Person(String name, Trouthers trouthers, Shooes shooes, Jacket jacket){
        this.name = name;
        this.trouthers = trouthers;
        this.shooes = shooes;
        this.jacket = jacket;
    }

    void takeon() {
        this.trouthers.takeon();
        this.jacket.takeon();
        this.shooes.takeon();

    }
    void takeoff() {
        this.trouthers.takeoff();
        this.jacket.takeoff();
        this.shooes.takeoff();

    }

}
