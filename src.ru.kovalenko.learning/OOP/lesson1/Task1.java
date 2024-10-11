package OOP.lesson1;

/*
Создать класс Student с полями: имя, возраст, средний балл.

Создать класс Group с полем массив студентов и методами: добавить студента, удалить студента,
вывести средний балл группы.

Создать класс Main с методом main(), в котором создать группу студентов, добавить в нее нескольких студентов,
вывести средний балл группы.
 */


import java.util.Arrays;
import java.util.Objects;

public class Task1 {
    public static void main(String[] args) {
        Group group = new Group(3);
        Student st1 = new Student("Roman", 36, 8.0);
        Student st2 = new Student("Artem", 30, 10.0);
        Student st3 = new Student("Dima", 32, 5.5);
        Student st4 = new Student("Тест", 10, 12.0);

        group.addStudent(st1);
        group.addStudent(st2);
        group.addStudent(st3);
        group.addStudent(st4);
        group.printGroup();

        System.out.println("Средний балл группы: " + group.getAverageGrade());
        group.removeStudent(st3);
        group.printGroup();
        System.out.println("Средний балл группы: " + group.getAverageGrade());
    }
}

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.grade, grade) == 0 && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}

class Group {
    int size = 0;
    Student[] students;

    public Group(int capacity) {
        students = new Student[capacity];
    }

    public void addStudent(Student student) {
        if (size == students.length) {
            System.out.println("Группа заполнена! Создайте новую или удалите какого-либо студента");
        } else {
            students[size++] = student;
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < size; i++) {
            if (students[i].equals(student)) {
                System.arraycopy(students, i + 1, students, i, size - i - 1);
                students[--size] = null;
            }
        }
    }

    public double getAverageGrade() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += students[i].getGrade();
        }
        return sum / size;
    }

    public void printGroup() {
        System.out.println("-------------");
        System.out.println("Состав группы");
        System.out.println(Arrays.toString(students));
        System.out.println("-------------");
    }
}
