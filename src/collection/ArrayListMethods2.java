package collection;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListMethods2 {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        System.out.println(st1); // Student{name='Ivan', sex=m, age=22, course=3, avgGrade=8.3}

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList); // [Student{name='Ivan', sex=m, age=22, course=3, avgGrade=8.3}, Student{name='Nikolay', sex=m, age=28, course=2, avgGrade=6.4}, Student{name='Elena', sex=f, age=19, course=1, avgGrade=8.9}, Student{name='Petr', sex=m, age=35, course=4, avgGrade=7.0}, Student{name='Mariya', sex=f, age=23, course=3, avgGrade=7.4}]

        // Добавим st6, такого же как st5
        Student st6 = new Student("Mariya", 'f', 23, 3, 7.4);
//        studentList.add(st6); // Теперь вообще не будем добавлять st6, чтобы продемонстрировать, что st5 тоже удалится
        System.out.println(studentList); // [Student{name='Ivan', sex=m, age=22, course=3, avgGrade=8.3}, Student{name='Nikolay', sex=m, age=28, course=2, avgGrade=6.4}, Student{name='Elena', sex=f, age=19, course=1, avgGrade=8.9}, Student{name='Petr', sex=m, age=35, course=4, avgGrade=7.0}, Student{name='Mariya', sex=f, age=23, course=3, avgGrade=7.4}, Student{name='Mariya', sex=f, age=23, course=3, avgGrade=7.4}]
        studentList.remove(st6); // Удалится только st6, то есть уникальный по хэшкоду, а не по всем полям, поэтому st5 останется, даже несмотря на то, что все поля у него такие же
        System.out.println(studentList); // [Student{name='Ivan', sex=m, age=22, course=3, avgGrade=8.3}, Student{name='Nikolay', sex=m, age=28, course=2, avgGrade=6.4}, Student{name='Elena', sex=f, age=19, course=1, avgGrade=8.9}, Student{name='Petr', sex=m, age=35, course=4, avgGrade=7.0}, Student{name='Mariya', sex=f, age=23, course=3, avgGrade=7.4}]
        // Но попробуем переопределить метод equals() в классе Student
        // Теперь даже удалив st6, у нас удалится st5, то есть обеих Марий не будет
        // Это происходит, поскольку удаление или поиск элемента проходит с использованием метода equals

    }

}

class Student {

    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex &&
                age == student.age &&
                course == student.course &&
                Double.compare(avgGrade, student.avgGrade) == 0 &&
                Objects.equals(name, student.name);
    }
}
