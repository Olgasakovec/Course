package sacovec.olga;

public class Employee {

    private String name;
    private String job;
    private String companySite;

    public Employee(String name, String job, String companySite) {
        this.name = name;
        this.job = job;
        this.companySite = companySite;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "name = '" + name + '\'' +
                ", job='" + job + '\'' +
                ", companySite = '" + companySite + '\'' +
                '}';
    }
}
