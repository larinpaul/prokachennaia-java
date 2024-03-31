package collection;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListMethods3 {

    // Добавляет все элементы из одного аррей листа в другой
    // addAll(ArrayList aL) -> boolean // добавляет в конец
    // addAll(int index, ArrayList aL) -> boolean // начиная с определенной позиции

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1); // [Zaur, Ivan, Mariya]
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("???");
        arrayList1.addAll(arrayList2);
        System.out.println(arrayList2); // [111, ???]
        System.out.println(arrayList1); // [Zaur, Ivan, Mariya, !!!, ???]

        // Если же например я захочу добавить все элементы аррэйЛист2 начиная с первой позиции,
        // Например [Zaur, !!!, ???, Ivan, Mariya]
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Zaur");
        arrayList3.add("Ivan");
        arrayList3.add("Mariya");
        arrayList3.addAll(1, arrayList2);
        System.out.println(arrayList3); // [Zaur, !!!, ???, Ivan, Mariya]


        // Следующий метод очень простой, он очищает наш аррэй лист
        // clear() ->
        arrayList1.clear();
        System.out.println(arrayList1); // []


        // indexOf(Object element) -> int // Принимает объект и возвращает его позицию (позицию искомого объекта используя метод equals)
        StudentWithNoEquals st1 =
                new StudentWithNoEquals("Ivan", 'm', 22, 3, 8.3);
        StudentWithNoEquals st2 =
                new StudentWithNoEquals("Nikolay", 'm', 28, 2, 6.4);
        StudentWithNoEquals st3 =
                new StudentWithNoEquals("Elena", 'f', 19, 1, 8.9);
        StudentWithNoEquals st4 =
                new StudentWithNoEquals("Petr", 'm', 35, 4, 7);
        StudentWithNoEquals st5 =
                new StudentWithNoEquals("Mariya", 'f', 23, 3, 7.4);
        ArrayList<StudentWithNoEquals> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList);
        StudentWithNoEquals st6 =
                new StudentWithNoEquals("Mariya", 'f', 23, 3, 7.4);
//        studentList.remove(st6);
        int index = studentList.indexOf(st6); // В отличие от примера со Student, в StudentWithNoEquals, такой st6 ни найден, ни удалён не будет
        System.out.println(index); // -1 // Если бы мы правильно оверрайдили equals, то сравнивались бы все поля

        Student st11 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st12 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st13 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st14 = new Student("Petr", 'm', 35, 4, 7);
        Student st15 = new Student("Mariya", 'f', 23, 3, 7.4);
        System.out.println(st11); // Student{name='Ivan', sex=m, age=22, course=3, avgGrade=8.3}
        Student st16 =
                new Student("Mariya", 'f', 23, 3, 7.4);

        ArrayList<Student> studentList2 = new ArrayList<>();
        studentList2.add(st11);
        studentList2.add(st12);
        studentList2.add(st13);
        studentList2.add(st14);
        studentList2.add(st15);
        System.out.println(studentList2); // [Student{name='Ivan', sex=m, age=22, course=3, avgGrade=8.3}, Student{name='Nikolay', sex=m, age=28, course=2, avgGrade=6.4}, Student{name='Elena', sex=f, age=19, course=1, avgGrade=8.9}, Student{name='Petr', sex=m, age=35, course=4, avgGrade=7.0}, Student{name='Mariya', sex=f, age=23, course=3, avgGrade=7.4}]
        int studentIndex = studentList2.indexOf(st16);
        System.out.println(studentIndex); // 4

        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Zaur");
        arrayList4.add("Ivan"); // Если у нас два Ивана, то будет выводиться позиция только первого
        arrayList4.add("Mariya");
        arrayList4.add("Ivan");
        System.out.println(arrayList4); // [Zaur, Ivan, Mariya, Ivan]
        System.out.println(arrayList4.indexOf("Ivan")); // 1
        // А еще есть метод ластИндексОф, он находит ПОСЛЕДНЕЕ совпадение! То есть поиск идет уже с правой стороны
        // lastIndexOf(Object element) -> int
        System.out.println(arrayList4.lastIndexOf("Ivan")); // 3

        // Следующий метод - это уже известный нам метод size()
        // size() -> int
        System.out.println(arrayList4.size()); // 4

        // Ещё есть метод isEmpty(), true если пуст и false если не пуст
        // isEmpty() -> boolean
        System.out.println(arrayList4.isEmpty()); // false
        System.out.println(arrayList1.isEmpty()); // true
        arrayList3.clear();
        System.out.println(arrayList3.isEmpty()); // true


        // Следующий метод проверяет, содержит ли наш аррэй лист какой-то элемент
        // Здесь так же используется метод equals() как и в других методах
        // Здесь также используется метод equals()
        // contains(Object element) -> boolean
        boolean status = studentList2.contains(st16);
        System.out.println(status); // true
        boolean status2 = studentList2.contains(st6);
        System.out.println(status2); // false
        System.out.println(arrayList4.contains("Kolya")); // false
        System.out.println(arrayList4.contains("Ivan")); // true
        System.out.println(arrayList4.contains("Mariya")); // true
        System.out.println(arrayList1.contains("Mariya")); // false


        // Ну а этом метод понятно, имеется у всех классов
        // Этот метод можно писать, а можно не писать
        // toString -> String
        System.out.println(arrayList4.toString()); // [Zaur, Ivan, Mariya, Ivan]
        System.out.println(arrayList4); // [Zaur, Ivan, Mariya, Ivan]
        // Когда мы выводим на экран ArrayList или любой другой объект, то он будет по умолчанию вызываться

    }

}

class StudentWithNoEquals {

    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public StudentWithNoEquals(String name, char sex, int age, int course, double avgGrade) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return sex == student.sex &&
//                age == student.age &&
//                course == student.course &&
//                Double.compare(avgGrade, student.avgGrade) == 0 &&
//                Objects.equals(name, student.name);
//    }
}
