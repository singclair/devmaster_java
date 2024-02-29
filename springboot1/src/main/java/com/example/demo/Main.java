package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Scanner;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Edit student by id");
            System.out.println("3. Delete student by id");
            System.out.println("4. Sort students by GPA");
            System.out.println("5. Sort students by name");
            System.out.println("6. Show students");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // consume newline left-over
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter student age:");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // consume newline left-over
                    System.out.println("Enter student address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter student GPA:");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();  // consume newline left-over

                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setAge(age);
                    student.setAddress(address);
                    student.setGpa(gpa);

                    String checkDuplicate = manager.checkDuplicate(id);
                    if(checkDuplicate.startsWith("Error")) {
                        System.out.println(checkDuplicate);
                        break;
                    }
                    manager.addStudent(student);

                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("Enter the ID of the student you want to edit:");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();  // consume newline left-over

                    String checkResult = manager.checkStudentExist(idToEdit);
                    if (checkResult.startsWith("Error")) {
                        System.out.println(checkResult);
                        break;
                    }

                    System.out.println("Enter new student name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new student age:");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();  // consume newline left-over
                    System.out.println("Enter new student address:");
                    String newAddress = scanner.nextLine();
                    System.out.println("Enter new student GPA:");
                    double newGpa = scanner.nextDouble();
                    scanner.nextLine();  // consume newline left-over

                    Student newStudent = new Student();
                    newStudent.setId(idToEdit);
                    newStudent.setName(newName);
                    newStudent.setAge(newAge);
                    newStudent.setAddress(newAddress);
                    newStudent.setGpa(newGpa);

                    manager.editStudent(idToEdit, newStudent);
                    System.out.println("Student details updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter the ID of the student you want to delete:");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();  // consume newline left-over

                    checkResult = manager.checkStudentExist(idToDelete);
                    if (checkResult.startsWith("Error")) {
                        System.out.println(checkResult);
                        break;
                    }


                    manager.deleteStudent(idToDelete);
                    System.out.println("Student deleted successfully.");
                    break;
                case 4:
                    manager.sortStudentsByGPA();
                    break;
                case 5:
                    manager.sortStudentsByName();
                    break;
                case 6:
                    manager.displayStudents();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 6.");
            }
        }
    }
}
