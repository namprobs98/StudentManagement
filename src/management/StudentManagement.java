/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import entity.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
        studentList.put("HE0001", new Student("HE0001", "Nam", 0));
        studentList.put("HE0002", new Student("HE0002", "My", 3));
        studentList.put("HE0003", new Student("HE0003", "Linh", 1));
        studentList.put("HE0004", new Student("HE0004", "Nam", 2));
        studentList.put("HE0005", new Student("HE0005", "Hanh", 2));
        studentList.put("HE0006", new Student("HE0006", "Hoang", 4));
        studentList.put("HE0007", new Student("HE0007", "Dung", 0));
        studentList.put("HE0008", new Student("HE0008", "Mai", 3));
        studentList.put("HE0009", new Student("HE0009", "Cuc", 1));
        studentList.put("HE0010", new Student("HE0010", "Thien", 2));


        String answer = "Y";

        System.out.println("----CREATE STUDENT----");
        do {
            String studentID = null;
            String studentName = null;
            String StudentSemester = null;
            String addCourse = null;
            Set<String> courses = new HashSet<>();
            //loop for check student id
            while (true) {
                System.out.print("Enter student ID: ");
                studentID = sc.nextLine();
                if (!check.isValidStudentID(studentID)) {
                    System.out.println("Student ID must be in the form HExxxx or HSxxxx. For example: HE1234");
                } else if (studentList.containsKey(studentID)) {
                    System.out.println("This ID already exists! ");
                } else {
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
            //loop for check add course
            while (true) {
                System.out.print("Enter semester: ");
                StudentSemester = sc.nextLine();
                if (check.isValidStudentSesmester(StudentSemester)) {
                    break;
                } else {
                    System.out.println("Student name is interger from 0 to 9.");
                }
            }
            //loop for check input add course:
            while (true) {
                System.out.println("(1)Java    (2).NET    (3)C/C++    (4)No course");
                System.out.print("Enter number ID of course of this student: ");
                addCourse = sc.nextLine();
                if (check.isValidAddCourse(addCourse)) {
                    break;
                } else {
                    System.out.println("Student name is interger from 0 to 9.");
                }
            }
            int addCourseID = Integer.parseInt(addCourse);
            if (addCourseID == 1) {
                courses.add("Java");
            } else if (addCourseID == 2) {
                courses.add(".NET");
            } else if (addCourseID == 3) {
                courses.add("C/C++");
            } else if (addCourseID == 4) {
            } else if (addCourseID == 12 || addCourseID == 21) {
                courses.add("Java");
                courses.add(".NET");
            } else if (addCourseID == 13 || addCourseID == 31) {
                courses.add("Java");
                courses.add("C/C++");
            } else if (addCourseID == 23 || addCourseID == 32) {
                courses.add(".NET");
                courses.add("C/C++");
            } else {
                courses.add("Java");
                courses.add(".NET");
                courses.add("C/C++");
            }

            System.out.println(studentID + "   " + studentName + "   " + StudentSemester + "   " + courses.toString());
            Student std = new Student(studentID, studentName, Integer.parseInt(StudentSemester), courses);
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

    //Find and sort
    public void findAndSortStudent() {
        Map<String, Student> result = new HashMap<>();
        String searchKeyword;
        System.out.println("Enter keyword of name of student who you want to search: ");
        searchKeyword = sc.nextLine();
        for (Map.Entry<String, Student> entry : studentList.entrySet()) {
            String studentName = entry.getValue().getStudentName().toLowerCase();
            if (containsOrdered(studentName, searchKeyword.toLowerCase())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        
        List<Student> sortedResult = new ArrayList<>(result.values());
        // Sắp xếp danh sách theo tên
        sortedResult.sort(Comparator.comparing(student -> student.getStudentName()));
         for (Student student : sortedResult) {
            System.out.println("Student ID: " + student.getStudentID() +
                               ", Student Name: " + student.getStudentName() +
                               ", Student Semester: " + student.getSemester());
        }
    }

    //checks whether a name string contains all the characters of the search string and in the correct order.
    public static boolean containsOrdered(String name, String search) {
        int index = -1;
        for (char c : search.toCharArray()) {
            index = name.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
