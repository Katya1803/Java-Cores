package collections;
import a.example.Example;

public class CollectionsExample implements Example {
    @Override
    public void run() {
        StudentManager manager = new StudentManager();

        Student student1 = new Student(1, "Alice", 22);
        Student student2 = new Student(2, "Bob", 20);
        Student student3 = new Student(3, "Charlie", 23);

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        System.out.println("\nList of students:");
        manager.listStudents();

        System.out.println("\nSorting students by name:");
        manager.sortStudentsByName();

        System.out.println("\nSorting students by age:");
        manager.sortStudentsByAge();

        System.out.println("\nRemoving student with ID 2:");
        manager.removeStudent(2);

        System.out.println("\nList of students after removal:");
        manager.listStudents();

        System.out.println("\nGetting student with ID 1:");
        Student student = manager.getStudent(1);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }
}
