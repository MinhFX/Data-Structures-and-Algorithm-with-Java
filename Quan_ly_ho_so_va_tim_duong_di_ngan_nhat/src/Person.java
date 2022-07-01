public class Person {
    int id;
    String name;
    String birthplace;
    String dob;

    public Person(int id, String name, String birthplace, String dob) {
        this.id = id;
        this.name = name;
        this.birthplace = birthplace;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-10s%-15s%-15s", id, name, dob, birthplace);
    }
}
