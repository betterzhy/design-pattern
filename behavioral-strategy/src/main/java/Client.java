import java.util.Arrays;
import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        Person person1 = new Person(170, 120);
        Person person2 = new Person(171, 118);
        Person person3 = new Person(169, 129);
        Person[] people = new Person[]{person1, person2, person3};
        Arrays.sort(people, new SortByHeight());
        for (Person person : people) {
            System.out.println(person);
        }

        Arrays.sort(people, new SortByWeight());
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

class Person {
    private double height;
    private double weight;

    public Person(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class SortByHeight implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getHeight() > o2.getHeight()) {
            return 1;
        } else if (o1.getHeight() < o2.getHeight()) {
            return -1;
        }
        return 0;
    }
}

class SortByWeight implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else if (o1.getWeight() < o2.getWeight()) {
            return -1;
        }
        return 0;
    }
}



