/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermpreparation;

/**
 *
 * @author Anelia
 */
class Person {

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            this.age = Math.abs(age);
        } else {
            this.age = age;
        }
    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Person() {
        this("Ana", 20);
    }

    public Person(Person p) {
        setAge(p.getAge());
        setName(p.getName());
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

}

class Student extends Person {

    private int facultyNumber;

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        if (facultyNumber < 0) {
            this.facultyNumber = Math.abs(facultyNumber);
        } else {
            this.facultyNumber = facultyNumber;
        }
    }

    public Student(int facultyNumber, String name, int age) {
        super(name, age);
        setFacultyNumber(facultyNumber);
    }

    public Student() {
        this(25452, "Ani", 20);
    }

    public Student(Student s) {
        this(s.getFacultyNumber(), s.getName(), s.getAge());
    }

    @Override
    public String toString() {
        return "Student{" + "facultyNumber=" + facultyNumber + ' ' + super.toString()+'}';
    }
}

public class InheritanceTest {

    public static void main(String[] args) {
        Student s = new Student(25605, "Anelia", 23);
        System.out.println(s.toString());
    }

}

//there is a class worker, thaat inherits person
//it is right if we write
//Person persons[]=new Person[4];
//persons[0]=new Student(.....)
//persons[1]=new Worker(....) ..



//getclassname and instanseof