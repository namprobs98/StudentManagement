/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author Slime nightmare
 */
public class Validation {

    //Check subject have to be Java, .Net or C/C++
    public boolean isValidSubject(String subject) {
        return subject.equalsIgnoreCase("Java") || subject.equalsIgnoreCase(".Net") || subject.equalsIgnoreCase("C/C++");
    }

    //Check option is interger from 1 to 5
    public boolean isValidOption(String option) {
        return option.matches("[1-5]");
    }

    //Check valid student ID is form HExxxx or HSxxxx;
    public boolean isValidStudentID(String studentID) {
        return studentID.matches("^(HE|HS)\\d{4}$");

    }

    //Check valid studenName
    public boolean isValidStudentName(String studentName) {
        return true;
    }

    //Check valid sesmester is interger from 0 to 9
    public boolean isValidStudentSesmester(String studentSemester) {
        return studentSemester.matches("[0-9]");
    }

    //Check yes no answer
    public boolean isValidYesNo(String answer) {
        return answer.matches("[YyNn]");
    }

    //Check number ID of course to add course when create student:
    public boolean isValidAddCourse(String courseID) {
        return courseID.matches("(1|2|3|4|12|21|13|31|23|32|123|132|213|231|312|321)");
    }
}
