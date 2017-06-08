/**
 * Created by joshua.chi on 6/8/17.
 */
public class Person implements Comparable {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return age > p.age ? 1: -1;
    }

    public static void main(String[] args) {
        Person p1 = new Person(23);
        Person p2 = new Person(32);
        int i = p1.compareTo(p2);

        if (i == -1) {
            System.out.println("p1 is too young" );
        }
        else {
            System.out.println("p2 is too young" );
        }
    }
}
