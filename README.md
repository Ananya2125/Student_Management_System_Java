# Student Management System (Java)

## Overview

This is a simple console-based **Student Management System (SMS)** developed in Java. It allows users to **add**, **remove**, **update**, and **display** student records efficiently. The student data is persistently stored in a text file (`StudentData.txt`), enabling the system to retain information across multiple runs.

---

## Features

- **Add Student:** Add new student records with ID, Name, GPA, and City.
- **Remove Student:** Delete existing student records by ID.
- **Update Student:** Modify student details selectively.
- **Display Students:**
  - Sorted by Name (ascending order)
  - Sorted by GPA (descending order)
- **Persistent Storage:** All changes are saved automatically to a text file.
- **Simple Command-Line Interface:** Easy to use menu-driven interaction.

---

## Technologies Used

- Java (Core)
- File I/O for persistent storage
- Collections Framework (ArrayList, Iterator, Comparator)

---

## How to Use

1. Clone or download the repository.
2. Ensure you have Java installed (JDK 8 or above).
3. Compile the source code:
   javac StudentManagement.java
4. Run the application:
   java StudentManagement
5. Follow the on-screen menu prompts to manage student records.

## File Structure

StudentManagement.java - Main program handling menu, input/output, and file operations.

Student.java - Model class representing the student entity.

StudentData.txt - Text file storing student data persistently.

---

## Sample Input Format (for StudentData.txt)

101,Aarav,8.5,Delhi
102,Ananya,9.2,Noida
103,Rahul,7.8,Bangalore


