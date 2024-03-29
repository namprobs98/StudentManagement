/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.HashSet;
import java.util.Set;
import management.Validation;

/**
 *
 * @author Slime nightmare
 */
public class Student {
    private String studentID;
    private String studentName;
    private int semester;
    private Set<String> courses;
    
    private Validation check;

    public Student(String studentID, String name, int semester) {
        this.studentID = studentID;
        this.studentName = name;
        this.semester = semester;
        this.courses = new HashSet<>();
    }

    public Student(String studentID, String name, int semester, Set<String> courses) {
        this.studentID = studentID;
        this.studentName = name;
        this.semester = semester;
        this.courses = courses;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }

    public Validation getCheck() {
        return check;
    }

    public void setCheck(Validation check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentName=" + studentName + ", semester=" + semester + ", courses=" + courses + ", check=" + check + '}';
    }

    
    
}
