/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class EmployeeTest {

    public static void main(String[] args) {
        //declaration
        Employee em;
        String fName, lName;
        double salary, salaryPerYear, salaryAfterRaise;

        Scanner kbd;
        //initialization

        
        for (int i = 0; i < 2; i++) {
            kbd = new Scanner(System.in);
            System.out.print("Enter first name: ");
            fName = kbd.nextLine();

            System.out.print("Enter last name: ");
            lName = kbd.nextLine();

            System.out.print("Enter salary: ");
            salary = kbd.nextInt();

            em = new Employee(fName, lName, salary);
            //processing
            salaryPerYear = em.getSalary() * 12;

            salaryAfterRaise = (em.getSalary() / 10) + em.getSalary();
            
            //output
            System.out.printf("A person %s%s"
                    + " gets salary per year: %.2f%n", fName, lName, salaryPerYear);

            

            System.out.printf("A person %s%s"
                    + " gets salary after raise per year: %.2f%n", fName, lName, salaryAfterRaise*12);

        }
    }

}
