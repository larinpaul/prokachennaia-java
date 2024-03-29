package collection;

import java.util.ArrayList;

public class ArrayListEx1 {

    public static void main(String[] args) {

        // Первый вариант создания
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1);

        // Следующий вариант создания (Просто справа дататайп не указывается)
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Zaur");
        arrayList2.add("Ivan");
        arrayList2.add("Mariya");
        System.out.println(arrayList2);

        // Когда мы создаем ArrayList, создается массив вместимости 10,
        // то есть capacity будет 10, хотя размер будет 0



    }

}
