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
public class EnumTest {
    public enum daysOfWeek {MONDAY, THUESDAY,WEDNESDAY,THURSDAY,FRIDAY, SATURDAY, SUNDAY};
    
    public static void printGreeting(daysOfWeek d){
        switch(d){
            case MONDAY : System.out.println("Dont talk to me");break;
            case THUESDAY : System.out.println("Hi"); break;
            case WEDNESDAY : System.out.println("Good Morning, people");break;
            case THURSDAY : System.out.println("Goood Morning, fiends");break;
            case FRIDAY : System.out.println("Goood Morning, my beautiful fiends. It it a wonderful day!");break;
            default : System.out.println("It is weekend and I do not have to say hallo!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        daysOfWeek d=daysOfWeek.FRIDAY;
        printGreeting(d);
    }
    
}
