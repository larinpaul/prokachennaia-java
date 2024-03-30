package collection;

import java.util.ArrayList;

public class ArrayListMethods1 {

    // Методы ArrayList
    // add(DataType element) -> boolean
    // add(int index, DataType element) -> boolean

    public static void main(String[] args) {

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");

        for (String s : arrayList1) {
            System.out.print(s + " ");
        } // Zaur Ivan Mariya
        System.out.println();

        arrayList1.add(1, "Misha");

        for (String s : arrayList1) {
            System.out.print(s + " ");
        } // Zaur Misha Ivan Mariya
        System.out.println();

        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 6, Size: 3
//        arrayList1.add(6, "Misha"); //
        // Нельзя создавать ArrayList с примитивными типами данных
//        ArrayList<int> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(6);
        System.out.println();

        // get(int index) -> DataType

        System.out.println(arrayList1.get(2)); // Ivan
        System.out.println();

        // С помощью метода get мы можем вывести все элементы, используя например традиционный for loop
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
        System.out.println();

        // Но можно и просто выводить переменную ArrayList
        System.out.println(arrayList1); // [Zaur, Misha, Ivan, Mariya]
        System.out.println();

        // set(int index, DataType element) -> DataType
        // Метод set можно рассматривать как replace,
        // То есть он заменит элемент на том индексе на вот этот который мы указываем
        arrayList1.set(1, "Masha");
        System.out.println(arrayList1); // [Zaur, Masha, Ivan, Mariya]
        System.out.println();

        // remove(Object element) -> boolean // true если удалён, false если не найден
        // remove(int index) -> DataType
        arrayList1.remove(0);
        System.out.println(arrayList1); // [Masha, Ivan, Mariya]
        System.out.println();
//        // Exception in thread "main" java.lang.IndexOutBoundsException: Index 8 out of bounds for length 3
//        arrayList1.remove(8);

        arrayList1.remove(0);
        System.out.println(arrayList1); // [Ivan, Mariya]
        System.out.println();

    }


}
