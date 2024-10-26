package utils;

import beans.Config;
import beans.Student;

public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requiredText("Enter name: ");
        String surname = InputUtil.requiredText("Enter surname: ");
        int age = InputUtil.requiredNumber("Enter age: ");
        String className = InputUtil.requiredText("Enter class name: ");

        Student student = new Student(name, surname, age, className);
        return student;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null || Config.students.length == 0) {
            System.out.println("No students registered yet.");
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            System.out.println((i + 1) + "." + student.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requiredNumber("How many students will you register?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". Register");
            Student student = StudentUtil.fillStudent();
            Config.students[i] = student;
        }
        System.out.println("\nRegistration completed successfully!\n");
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        if (Config.students == null || Config.students.length == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        String text = InputUtil.requiredText("Enter name, surname, or class name: ");
        Student[] foundStudents = findStudents(text);
        if (foundStudents.length == 0) {
            System.out.println("No students found with the given search criteria.");
        } else {
            for (Student student : foundStudents) {
                System.out.println(student.getFullInfo());
            }
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (Student student : Config.students) {
            if (student.getName().contains(text) || student.getSurname().contains(text) || student.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for (Student student : Config.students) {
            if (student.getName().contains(text) || student.getSurname().contains(text) || student.getClassName().contains(text)) {
                result[found] = student;
                found++;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject() {
        if (Config.students == null || Config.students.length == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        StudentUtil.printAllRegisteredStudents();
        int id = InputUtil.requiredNumber("Enter the ID of the student to be updated: ");
        if (id <= 0 || id > Config.students.length) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.println("Enter new information: ");
        Student student = StudentUtil.fillStudent();
        Config.students[id - 1] = student;
    }

    public static void updateStudentWithSameObject() {
        if (Config.students == null || Config.students.length == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        StudentUtil.printAllRegisteredStudents();
        int id = InputUtil.requiredNumber("Enter the ID of the student to be updated: ");
        if (id <= 0 || id > Config.students.length) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.println("Enter new information: ");
        Student selectedStudent = Config.students[id - 1];
        String changeParams = InputUtil.requiredText("What do you want to change? Example format: 'name','surname','className','age'");

        if (changeParams.contains("'name")) {
            selectedStudent.setName(InputUtil.requiredText("Name:"));
        }
        if (changeParams.contains("'surname")) {
            selectedStudent.setSurname(InputUtil.requiredText("Surname:"));
        }
        if (changeParams.contains("'className")) {
            selectedStudent.setClassName(InputUtil.requiredText("Class name:"));
        }
        if (changeParams.contains("'age")) {
            selectedStudent.setAge(InputUtil.requiredNumber("Age:"));
        }
    }

    public static void updateStudentWithSplit() {
        if (Config.students == null || Config.students.length == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requiredNumber("Enter the ID of the student to be updated: ");
        if (index <= 0 || index > Config.students.length) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.println("Enter new information: ");
        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requiredText("What do you want to change? Example format: name,surname,className,age");
        String[] parameters = changeParams.split(",");
        for (String param : parameters) {
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(InputUtil.requiredText("Name:"));
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(InputUtil.requiredText("Surname:"));
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(InputUtil.requiredNumber("Age:"));
            } else if (param.equalsIgnoreCase("className")) {
                selectedStudent.setClassName(InputUtil.requiredText("Class name:"));
            }
        }
    }

    public static void updateStudent() {
        updateStudentWithSameObject();  // Example of using one of the update methods
    }
}
