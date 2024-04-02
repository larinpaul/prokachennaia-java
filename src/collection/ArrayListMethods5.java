package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods5 {

    public static void main(String[] args) {

        String[] arrayList = new String[]{"1", "2", "3"};
        for (String s : arrayList) {
            System.out.println(s);
        }

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
        arrayList11.add("Elena"); // 4-й не включен
        System.out.println("ArrayLIst = " + arrayList11); // [Zaur, Ivan, Mariya, Kolya, Elena]
        // Теперь из этого аррэй листа создадим отрывок и будем помещать его в лист
        List<String> myList = arrayList11.subList(1, 4); // Второй параметр не включен, поэтому если мы хотим до 3 параметра, то мы пишем 4
        System.out.println("Sub list = " + myList); // [Ivan, Mariya, Kolya]
        // Теперь интересный момент.
        // На самом деле этот саблист myList не существует в отдельности от того листа...
        // Он лишь является его представлением (view).
        // То есть это не отдельная какая-то сущность...
        // Чтобы увидеть, что это не какая-то отдельная сущность,
        // давайте попробуем добавить в саблист отдельный элемент
        myList.add("Fedor");
        System.out.println("Sub list = " + myList);// [Ivan, Mariya, Kolya, Fedor]
        System.out.println("ArrayList = " + arrayList11); // [Zaur, Ivan, Mariya, Kolya, Fedor, Elena]
        // Теперь добавим не с помощью саблиста, а с помощью самого листа
//        arrayList11.add("Sveta");
//        System.out.println("ArrayList = " + arrayList11); // [Zaur, Ivan, Mariya, Kolya, Fedor, Elena, Sveta]
        // А вот что происходит когда я пытаюсь вывести саблист...
//        System.out.println("Sub list = " + myList);// [Ivan, Mariya, Kolya, Fedor]
        // Выкидывается java.util.ConcurrentModificationException!
        // Потому что все наши структурные модификации должны быть сделаны с помощью нашего view!
        // Если мы делаем модификацию над аррей листтом напрямую и потом пытаемся использовать представление (саблист), мы не получим нужный нам результат...

        // toArray()
        // toArray() -> Object[]
        // С помощью туАррэй мы из нашего аррэй листа получаем массив типа обжект
        ArrayList<String> arrayList111 = new ArrayList<>();
        arrayList111.add("Zaur");
        arrayList111.add("Ivan");
        arrayList111.add("Mariya");
        arrayList111.add("Kolya");
        arrayList111.add("Elena");
        System.out.println("ArrayList = " + arrayList111);
        Object[] array = arrayList111.toArray();
        System.out.println(arrayList111); // [Zaur, Ivan, Mariya, Kolya, Elena]
        System.out.println(array); // [Ljava.lang.Object;@2a84aee7]

        // Но поскольку у нас не Object, а String, то куда логичнее использовать другой метод...

        // toArray(T [] a) -> T []
        String[] array2 = arrayList111.toArray(new String[5]);
        for (String s : array2) {
            System.out.println(s); // Zaur /n Ivan /n Mariya /n Kolya /n Elena
        }
        // А если мы укажем не 5, а например семь...
        String[] array7 = arrayList111.toArray(new String[7]);
        // То тогда мы увидим 5 наших элементов, а два оставшихся будут заполнены null
        for (String s : array7) {
            System.out.println(s); // Zaur/nIvan/nMariya/nKolya/nElena/nnull/nnull
        }
        // А если мы укажем на 5, а например 3,
        // то джава достаточно умна, чтобы понять что в наш массив все элементы не влезают
        // и она создаст массив необходимого размера...
        String[] array3 = arrayList111.toArray(new String[3]);
        for (String s : array3) {
            System.out.println(s); // Zaur/nIvan/nMariya/nKolya/nElena
        }
        // При этом нельзя оставить new String[] пустым...
        // Но можно использовать 0!
        String[] array0 = arrayList111.toArray(new String[0]);
        for (String s : array0) {
            System.out.println(s); // Zaur/nIvan/nMariya/nKolya/nElena
        }

        // Ещё два метода, List.of() и List.copyOf
        // List.of(E ... elements) -> List<E>
        // List.copyOf(Collection <E> c) -> List<E>
        // Эти методы вышли после 8 джавы

        // Мы по-быстрому можем добавить элементы без метода list1.add
        List<Integer> list1 = List.of(3, 8, 13);
        System.out.println(list1); // [3, 8, 13]
        // Видоизменять этот лист нельзя...
//        list1.add(100); // java.lang.UncupportedOperationException
        // При этом метод of сильно Overloaded... то есть существует много вариантов его написания, очень много разных аргументов можно передать

        // И второй метод, List.copyOf(), он тоже статичный
        // принимает параметрами коллекцию и возвращает тоже анмадифайабл лист
        ArrayList<String> arrayList1111 = new ArrayList<>();
        arrayList1111.add("Zaur");
        arrayList1111.add("Ivan");
        arrayList1111.add("Mariya");
        arrayList1111.add("Kolya");
        arrayList1111.add("Elena");

        List<Integer> list1111 = List.of(3, 8, 13);
        System.out.println(list1111);

        List<String> list2222 = List.copyOf(arrayList1111);
        System.out.println(list2222); // [Zaur, Ivan, Mariya, Kolya, ELena]
        // И да, его модифицировать мы тоже не можем
//        list2222.add("Test"); // UnsupportedOperationException
        // Кроме того, что эти листы нельзя модифицировать,
        // они также не могут содержать значения null
//        List<Integer> list0 = List.of(1, 2, null); // java.lang.NullPointerException

        // То есть запомним, налл они содержать не могут, и они НЕИЗМЕНЯЕМЫ

    }
}
