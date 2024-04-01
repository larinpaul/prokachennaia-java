package collection;

import java.util.Arrays;
import java.util.List;

public class ArrayListMethods4 {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");

        // Метод asList
        // Arrays.asList(DataType []) -> List<DataType>

        StringBuilder[] array = {sb1, sb2, sb3, sb4};
        List<StringBuilder> list = Arrays.asList(array); // Этот лист будет той же длины что и тот массив. Длина его измениться не может.
        System.out.println(list); // [A, B, C, D]
        // Если мы что-то заменим в изначальном массиве, то это отразится в листе тоже
        array[0].append("!!!"); // мы изменили sb1
        System.out.println(list); // [A!!!, B, C, D]
        // А если мы не изменим элемент, а поставим на его место другой?
        array[0] = new StringBuilder("F");
        System.out.println(list); // [F, B, C, D]

        // Следующий метод - removeAll
        // removeAll(Collection<C> c) -> boolean
        // Он работает так же как и ремув, он удаляет из нашего аррэйлиста все элементы, которые находятся в параметрах



    }

}
