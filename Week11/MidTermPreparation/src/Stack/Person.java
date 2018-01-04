/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Anelia
 */
public class Person implements Comparable {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {

        Person temp = (Person) o;
        if (this.age < temp.age) {
            return -1;
        }

        if (this.age == temp.age) {
            return 0;
        }

        return 1;

    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name=" + name + '}';
    }
    
    

}
