package Encapsulation.sortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String secondName, int age) {
        setFirstName(firstName);
        setLastName(secondName);
        setAge(age);
    }
    @Override
    public String toString() {
        return String.format("%s %s is %d years old.",firstName, lastName,age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
