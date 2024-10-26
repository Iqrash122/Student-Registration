package main;

import utils.InputUtil;
import utils.StudentUtil;

public class Main {

    public static void main(String[] args) {
        while (true) {
            int menu = InputUtil.requiredNumber("\nWhat do you want to do?"
                    + "\n1. Register"
                    + "\n2. Show all students"
                    + "\n3. Find student"
                    + "\n4. Update student"
                    + "\n5. Exit\n");

            switch (menu) {
                case 1:
                    StudentUtil.registerStudents();
                    break;
                case 2:
                    StudentUtil.printAllRegisteredStudents();
                    break;
                case 3:
                    StudentUtil.findStudentsAndPrint();
                    break;
                case 4:
                    StudentUtil.updateStudent();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
