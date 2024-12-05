package AlgoAndDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Пробрасываю все методы в стандартную библиотеку, кроме поиска в массиве int.
На нем рассматриваю алгоритм работы (см мой класс Arrays)
Анимация бинарного поиска https://tenor.com/ru/view/binary-search-sequence-search-gif-20595028
*/
public class Main {
    public static void main(String[] args) {
        int[] testArr = {0, 4, 5, 8, 11, 12, 14, 17, 19, 21};
        System.out.println("Тестирование бинарного поиска для массива int");
        // Ищем число, которое есть в массиве
        getInfo(testArr, 8);
        // Ищем число, которого нет в массиве
        getInfo(testArr, 15);

        System.out.println("Тестирование бинарного поиска для коллекций");

        Test test1 = new Test(1, "Roman");
        Test test2 = new Test(2, "Kseniya");
        Test test5 = new Test(5, "Dmitriy");
        List<Test> arrListTest = new ArrayList<>();
        arrListTest.add(test1);
        arrListTest.add(test2);
        arrListTest.add(test5);

        Test test8 = new Test(8, "Alexandra");
        Test test9 = new Test(9, "Artem");
        Test test12 = new Test(12, "Elena");
        List<Test> linkListTest = new LinkedList<>();
        linkListTest.add(test8);
        linkListTest.add(test9);
        linkListTest.add(test12);

        System.out.println("Поиск в коллекций имплементирующей RandomAccess (ArrayList)");
        getInfo(arrListTest, new Test(2, "test"));
        getInfo(arrListTest, new Test(4, "test"));
        System.out.println("Поиск в коллекций не имплементирующей RandomAccess (LinkedList)");
        getInfo(linkListTest, new Test(8, "test"));
        getInfo(linkListTest, new Test(15, "test"));
    }

    private static void getInfo(int[] arr, int key) {
        System.out.println("Ищем по ключу в массиве " + java.util.Arrays.toString(arr));
        int index = Arrays.binarySearch(arr, key);
        if (index >= 0) {
            System.out.println("Элемент: " + key + " найден по индексу: " + index);
        } else {
            System.out.println("Элемент: " + key + " не найден. Но его можно вставить по индексу: " + (-index - 1));
            System.out.println("Но для этого надо создать копию массива с большей длиной");
            System.out.println("Сместить элементы вправо начиная с индекса вставки");
            System.out.println("И наконец вставить элемент по найденному индексу");
        }
    }

    private static <T> void getInfo(List<? extends Comparable<? super T>> list, T key) {
        System.out.println("Ищем по ключу id в коллекции " + list);
        int index = Collections.binarySearch(list, key);
        if (index >= 0) {
            System.out.println("Элемент c id " + ((Test) key).getId() + " найден по индексу " + index);
        } else {
            System.out.println("Элемент с id " + ((Test) key).getId() +
                    " не найден, но его можно вставить по индексу " + (-index - 1));
            if ((-index - 1) == list.size()) {
                System.out.println("Можно добавить в конец коллекции");
            } else {
                System.out.println("Вставка элемента в коллекцию сместит значения после него на одну позицию вправо");
            }
        }
    }
}

class Test implements Comparable<Test> {
    Integer id;
    String name;

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    @Override
    public int compareTo(Test o) {
        return id - o.getId();
    }
}
