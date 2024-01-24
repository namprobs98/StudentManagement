/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import entity.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Slime nightmare
 */
public class StudentManagement {

    private Map<String, Student> studentList;

    private Scanner sc = new Scanner(System.in);
    private Validation check = new Validation();

    public StudentManagement() {
        this.studentList = new HashMap<>();
    }

    public Map<String, Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Map<String, Student> studentList) {
        this.studentList = studentList;
    }

    //Main menu
    public int mainOption() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
        String option;
        //Loop for check option
        while (true) {
            option = sc.nextLine();
            if (check.isValidOption(option)) {
                break;
            } else {
                System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
            }
        }
        return Integer.parseInt(option);
    }

    //Create student
    public void createStudent() {

        String studentID = null;
        String studentName = null;
        String StudentSemester = null;
        String answer = "Y";

        System.out.println("----CREATE STUDENT----");
        do {
            //loop for check student id
            while (true) {
                System.out.print("Enter student ID: ");
                studentID = sc.nextLine();
                if (!check.isValidStudentID(studentID)) {
                    System.out.println("Student ID must be in the form HExxxx or HSxxxx. For example: HE1234");
                }
                else if(studentList.containsKey(studentID)){
                    System.out.println("This ID already exists! ");
                }
                else {
                    break;
                }
            }
            //loop for check student name
            while (true) {
                System.out.print("Enter student name: ");
                studentName = sc.nextLine();
                if (check.isValidStudentName(studentName)) {
                    break;
                } else {
                    System.out.println("Student name is not valid.");
                }
            }
            while (true) {
                System.out.print("Enter semester: ");
                StudentSemester = sc.nextLine();
                if (check.isValidStudentSesmester(StudentSemester)) {
                    break;
                } else {
                    System.out.println("Student name is interger from 0 to 9.");
                }
            }
            System.out.println(studentID +"   "+ studentName + "   " + StudentSemester);
            Student std = new Student(studentID, studentName, Integer.parseInt(StudentSemester));
            studentList.put(studentID, std);
            if (studentList.size() > 10) {

                while (true) {
                    System.out.print("Do you want to continue (Y/N)? ");
                    answer = sc.nextLine();
                    if (check.isValidYesNo(answer)) {
                        break;
                    } else {
                        System.out.println("Only answer Y or N. ");
                    }
                }
                if (answer.equalsIgnoreCase("N")) {
                    break;
                }
            }
        } while (true);
    }

}
