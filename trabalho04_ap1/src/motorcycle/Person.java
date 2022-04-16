package motorcycle;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        String texto = "[";
        texto += this.name;
        texto += ":";
        texto += this.age;
        texto += "]";
        return texto;
    }
}