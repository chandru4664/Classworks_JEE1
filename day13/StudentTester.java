package com.htc.ioss;
public class StudentTester {

    public static void main(String[] args) {
     StudentSaver students = new StudentSaver();
     StudentTO student = new StudentTO(1000, "Vivek", "CICS");
     students.saveStudent(student);
     student = new StudentTO(1010, "Sameer", "DB2");
     students.saveStudent(student);
     student = new StudentTO(1020, "Satish", "COBOL");
     students.saveStudent(student);
     student=new StudentTO(1030,"Ram","Java");
     students.saveStudent(student);
     students.readStudents();
     
    }

}
