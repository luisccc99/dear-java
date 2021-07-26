package LombokVBoilerplate;

/**
 * A lot of boilerplate for a dog class hmmmm...
 */
public class Dog {
    private String name;
    private String breed;
    private int age;
    private String color;

    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    public Dog() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" + 
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age + 
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;
        if (age != dog.age) return false;
        if (!name.equals(dog.getName())) return false;
        if (!breed.equals(dog.getName())) return false;
        if (!color.equals(dog.getColor())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + breed.hashCode();
        result = 31 * result + age;
        result = 31 * result + color.hashCode();
        return result;
    }
}