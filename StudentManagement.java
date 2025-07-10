package Student_Management_Sytstem_project;

import java.io.*;
import java.util.*;

public class StudentManagement {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "StudentData.txt";
        readStudentData(fileName);

        Scanner ab = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("____Student Management System____");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Student by Name (Asc.)");
            System.out.println("5. Display students by Gpa (Desc.)");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            int choice = ab.nextInt();
            switch (choice) {
                case 1:
                    addStudent(ab, fileName);
                    break;
                case 2:
                    removeStudent(ab, fileName);
                    break;
                case 3:
                    updateStudent(ab, fileName);
                    break;
                case 4:
                    displayStudentByName();
                    break;
                case 5:
                    displayStudentByGPA();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for using SMS.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again between 1-6");
                    break;
            }
        }
    }

    public static void readStudentData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
                String city = data[3].trim();
                String university = "ABES";

                Student student = new Student(id, name, gpa, city, university);
                students.add(student);
            }
            System.out.println("Student data loaded successfully");
        } catch (IOException e) {
            System.out.println("Error occurred while reading  :( " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format :( " + e.getMessage());
        }
    }

    public static void addStudent(Scanner ab, String fileName) {
        System.out.println("____Add Student_____");
        System.out.println("Enter details: ID, Name, GPA, City");
        int id = ab.nextInt();
        ab.nextLine();
        String name = ab.nextLine();
        // ab.nextLine();
        double gpa = ab.nextDouble();
        ab.nextLine();
        String city = ab.nextLine();
        Student student = new Student(id, name, gpa, city, "ABES");
        students.add(student);
        writeStudentData(fileName);
        System.out.println("Student added :)");
    }

    public static void removeStudent(Scanner ab, String fileName) {
        System.out.println("____Remove Student____");
        System.out.println("Enter the id of student to be removed: ");
        int id = ab.nextInt();
        boolean found = false;
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student st = itr.next();
            if (st.getId() == id) {
                itr.remove();
                found = true;
                break;
            }
        }
        if (found) {
            writeStudentData(fileName);
            System.out.println("Student removed successfully :)");
        } else {
            System.out.println("Student not found with the given id :(");
        }
    }

    public static void updateStudent(Scanner ab, String fileName) {
        System.out.println("___Update Student____");
        System.out.println("Enter id of student to be updated: ");
        int id = ab.nextInt();
        boolean found = false;
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student st = itr.next();
            if (st.getId() == id) {
                System.out.println("Enter name: ");
                String name = ab.next();
                if (!name.isEmpty()) {
                    st.setName(name);
                }
                System.out.println("Enter GPA: ");
                String gpa = ab.next();
                if (!gpa.isEmpty()) {
                    st.setGpa(Double.parseDouble(gpa));
                }
                System.out.println("Enter city: ");
                String city = ab.next();
                if (!city.isEmpty()) {
                    st.setCity(city);
                }
                found = true;
                break;
            }
        }
        if (found) {
            writeStudentData(fileName);
            System.out.println("Student info. updated successfully :)");
        } else {
            System.out.println("Student not found with the given id :(");
        }

    }

    public static void displayStudentByName() {
        System.out.println("___Students by Name(asc.)___");
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents, Comparator.comparing(Student::getName));

        System.out.println("ID\tName\tGPA\tCity\tUniversity");
        System.out.println("***************************************");
        displayStudent(sortedStudents);
    }

    public static void displayStudentByGPA() {
        System.out.println("___Students by GPA(desc.)___");
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents, Comparator.comparing(Student::getGpa).reversed());

        System.out.println("ID\tName\tGPA\tCity\tUniversity");
        System.out.println("***************************************");
        displayStudent(sortedStudents);
    }

    public static void displayStudent(List<Student> st) {
        for (Student s : st) {
            System.out.println(s);
        }
    }

    public static void writeStudentData(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                String line = s.getId() + "," + s.getName() + "," + s.getGpa() + "," + s.getCity();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
