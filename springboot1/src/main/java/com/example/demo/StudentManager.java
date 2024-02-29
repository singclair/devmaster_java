package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(int id, Student newStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, newStudent);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void sortStudentsByGPA() {
        students.sort(Comparator.comparingDouble(Student::getGpa));
    }

    public void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Address: " + student.getAddress());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("-------------------------");
        }
    }
    public String checkStudentExist(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return "Student exists.";
            }
        }
        return "Error: Student does not exist.";
    }
    public String checkDuplicate(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return "Error: Student id duplicate.";
            }
        }
        return "Success: Student id not duplicate.";
    }
}