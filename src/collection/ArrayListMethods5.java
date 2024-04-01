package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods5 {

    public static void main(String[] args) {

        // removeAll(Collection <?> c) -> boolean

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        System.out.println(arrayList1); // [Zaur, Ivan, Mariya, Kolya]

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Ivan");
        arrayList2.add("Mariya");
        arrayList2.add("Igor");

        arrayList1.removeAll(arrayList2);
        System.out.println(arrayList1); // [Zaur, Kolya]

        // retainAll
        // retainAll(Collection<?> c) ->
        // Очень похож на removeAll, но является полной его противоположностью
        // Он оставит в аррэй листе те элементы, которые есть в листе из параметра
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Zaur");
        arrayList3.add("Ivan");
        arrayList3.add("Mariya");
        arrayList3.add("Kolya");
        System.out.println(arrayList3); // [Zaur, Ivan, Mariya, Kolya]
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Ivan");
        arrayList4.add("Mariya");
        arrayList4.add("Igor");
        arrayList3.retainAll(arrayList4);
        System.out.println(arrayList3); // ["Ivan", "Mariya"]

        // containsAll
        // containsAll(Collection <?> c) -> boolean
        // Он проверяет, содержит ли аррэй все элементы аррэй листа из этого параметра
        boolean result = arrayList3.containsAll(arrayList4);
        System.out.println(result); // false, потому что в arrayList3 нет Игоря Igor
        arrayList4.remove("Igor");
        boolean resutl2 = arrayList3.containsAll(arrayList4);
        System.out.println(resutl2); // true потому что теперь и в arrayList3 и в arrayList4 нет Игоря

        // subList
        // subList(int fromIndex, int toIndex) -> List<E>
        // он создает из имеющегося аррэй листа саблист, то есть как-бы его отрывок
        // возвращает уже не ArrayList, а List...
        // Что это за отрывок который он возвращает, сейчас будем разбираться
        ArrayList<String> arrayList11 = new ArrayList<>();
        arrayList11.add("Zaur"); // 0
        arrayList11.add("Ivan"); // 1
        arrayList11.add("Mariya"); // 2
        arrayList11.add("Kolya"); // 3
        arrayList11.add("Elena"); // 4й не включен
        System.out.println(arrayList11); // [Zaur, Ivan, Mariya, Kolya, Elena]
        // Теперь из этого аррэй листа создадим отрывок и будем помещать его в лист
        List<String> myList = arrayList11.subList(1, 4); // Второй параметр не включен, поэтому если мы хотим до 3 параметра, то мы пишем 4
        System.out.println(myList); // [Ivan, Mariya, Kolya]
        // Теперь интересный момент.
        // На самом деле этот саблист myList не существует в отдельности от того листа...
        // Он лишь является его представлением (view).
        // То есть это не отдельная какая-то сущность...
        // Чтобы увидеть, что это не какая-то отдельная сущность,
        // давайте попробуем добавить в саблист отдельный элемент
        myList.add("Fedor");
        System.out.println(myList);// [Ivan, Mariya, Kolya, Fedor]
        System.out.println(arrayList11); // [Zaur, Ivan, Mariya, Kolya, Fedor, Elena]


    }
}
