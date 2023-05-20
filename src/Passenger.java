public class Passenger {
    private int id;
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private String berth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    @Override
    public String toString() {
        return "ID - " + id + "\nName - " + name + "\nAge - " + age + "\nBerth - " + berth;
    }

}
