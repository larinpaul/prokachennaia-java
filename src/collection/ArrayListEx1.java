package collection;

import java.util.ArrayList;
import java.util.List;

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

        // Приведе пример в котором initialCapacity будет равна 200
        ArrayList<String> arrayList3 = new ArrayList<>(200);
        System.out.println(arrayList3.size());

        // Можно ArrayList создавать также просто через интерфейс List
        List<String> arrayList4 = new ArrayList<>();
        // Это возможно, поскольу List является интерфейсом, который имплементирует ArrayList

        // Если мы добавим в наш arrayList3 два элемента, то size будет 2, но capacity будет 200


        // Четвертый вариант создания ArrayList - когда мы помещаем в конструктор другой ArrayList
        ArrayList<String> list4 = new ArrayList<>(arrayList3);
        ArrayList<String> arrayList5 = new ArrayList<>(arrayList3);
        // При этом данные аррэй листы будут идентичными.
        // То есть если вам нужно создать другой аррэй лист,
        // вы помещаете в параметры конструктора ссылку на этот аррэй лист
        // Но это будет НОВЫЙ объект, он НЕ ССЫЛАЕТСЯ на тот же аррэй лист

        // Как мы можем проверить, ссылаются ли они на один и тот же объект или нет?
        System.out.println(arrayList5==arrayList3); // false
        // Эти переменные ссылаются на разные объекты,
        // Но элементы этих аррэй листов одинаковые.

        // Еще один момент. Если мы не будем указывать дженерик <String>,
        // то тогда в наш аррэй лист мы сможем положить всё что угодно
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add("Zaur");
        arrayList6.add("Ivan");
        arrayList6.add(50);
        arrayList6.add(150);
        arrayList6.add(new Car());
        System.out.println(arrayList6);
        // Но так делать НЕ СТОИТ
        // Всегда используйте дженерики!
        // А тут мы можем добавить все что угодно потому что ArrayList содержит массив[Object]

    }

}

class Car {

}
