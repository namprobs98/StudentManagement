/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package management;

/**
 *
 * @author Slime nightmare
 */
public class StudentManagementApp {

    /**
     * @param args the command line arguments
     */
    //Check valid student ID is form HExxxx or HSxxxx;
    public static void main(String[] args) {
        // TODO code application logic here
        int option;
        //Step 1: Main menu:
        StudentManagement sm = new StudentManagement();
        do{
            option = sm.mainOption();
            switch (option) {
                case 1:
                    sm.createStudent();
                    break;
            }
        }
        while (option == 5);
    }
}
