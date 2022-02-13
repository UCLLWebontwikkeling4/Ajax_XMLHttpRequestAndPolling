public class Lector {
    private String name;
    private String firstname;

    public Lector() {
    }

    public Lector(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
