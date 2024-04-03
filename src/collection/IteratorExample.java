package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

//        Iterator<String> iterator = arrayList1.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        } // This throws out an exception
        // But this works...
        Iterator<String> iterator2 = arrayList1.iterator();
        while (iterator2.hasNext()) {
            String nextElement = iterator2.next();
            System.out.println(nextElement);
        }

//        // Но в отличие от forEach loop, итератор также может удалять элементы...
//        for (String s : arrayList1) {
//            System.out.println(iterator.next());
//        }
//        for (String s : arrayList1) {
//            System.out.println(s);
//        }

        // Попробуем удалить элементы
        Iterator<String> iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(arrayList1); // []

        ArrayList<String> arrayList11 = new ArrayList<>();
        arrayList11.add("Zaur");
        arrayList11.add("Ivan");
        arrayList11.add("Mariya");
        arrayList11.add("Kolya");
        arrayList11.add("Elena");
        System.out.println(arrayList11);

        // Отметим такой момент, если мы не выполнили метод next(), то мы не получили элемент, а значит не можем ни удалить, ни даже распечатать, ибо будет выброшена ошибка
        Iterator<String> iterator11 =  arrayList11.iterator();
        while (iterator11.hasNext()) {
            iterator11.next(); // Если эту строку закомментировать, то не заработает...
            iterator11.remove();
        }
        System.out.println(arrayList11);

//        // Самые необходимые методы итератора...
//        // Iterator
//        // some code
//        // ...
//        Iterator<DataType> iter = aL.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
    }
}
