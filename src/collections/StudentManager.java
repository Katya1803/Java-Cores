package collections;

import java.util.*;

public class StudentManager {
    private List<Student> arrayListStudents;
    private List<Student> linkedListStudents;
    private Set<Student> hashSetStudents;
    private Set<Student> treeSetStudents;
    private Map<Integer, Student> hashMapStudents;
    private Map<Integer, Student> treeMapStudents;

    public StudentManager() {
        this.arrayListStudents = new ArrayList<>();
        this.linkedListStudents = new LinkedList<>();
        this.hashSetStudents = new HashSet<>();
        this.treeSetStudents = new TreeSet<>(Comparator.comparingInt(Student::getId));
        this.hashMapStudents = new HashMap<>();
        this.treeMapStudents = new TreeMap<>();
    }

    public void addStudent(Student student) {
        arrayListStudents.add(student);
        linkedListStudents.add(student);
        hashSetStudents.add(student);
        treeSetStudents.add(student);
        hashMapStudents.put(student.getId(), student);
        treeMapStudents.put(student.getId(), student);
        System.out.println("Added: " + student);
    }

    public void removeStudent(int studentId) {
        arrayListStudents.removeIf(student -> student.getId() == studentId);
        linkedListStudents.removeIf(student -> student.getId() == studentId);
        hashSetStudents.removeIf(student -> student.getId() == studentId);
        treeSetStudents.removeIf(student -> student.getId() == studentId);
        hashMapStudents.remove(studentId);
        treeMapStudents.remove(studentId);
        System.out.println("Removed student with ID: " + studentId);
    }

    public Student getStudent(int studentId) {
        return hashMapStudents.get(studentId);
    }

    public void listStudents() {
        System.out.println("ArrayList:");
        arrayListStudents.forEach(System.out::println);

        System.out.println("LinkedList:");
        linkedListStudents.forEach(System.out::println);

        System.out.println("HashSet:");
        hashSetStudents.forEach(System.out::println);

        System.out.println("TreeSet:");
        treeSetStudents.forEach(System.out::println);

        System.out.println("HashMap:");
        hashMapStudents.values().forEach(System.out::println);

        System.out.println("TreeMap:");
        treeMapStudents.values().forEach(System.out::println);
    }

    public void sortStudentsByName() {
        arrayListStudents.sort(Comparator.comparing(Student::getName));
        linkedListStudents.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by name:");
        listStudents();
    }

    public void sortStudentsByAge() {
        arrayListStudents.sort(Comparator.comparingInt(Student::getAge));
        linkedListStudents.sort(Comparator.comparingInt(Student::getAge));
        System.out.println("Students sorted by age:");
        listStudents();
    }
}
