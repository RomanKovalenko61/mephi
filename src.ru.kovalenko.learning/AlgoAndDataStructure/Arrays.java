package AlgoAndDataStructure;

import java.util.Comparator;

/*
Пробрасываю все методы в стандартную библиотеку, кроме поиска в массиве int.
Рассматриваю алгоритм бинарного поиска на примере поиска в массиве int.
Добавлено описание над приватным методом binarySearch0(int[] a, int fromIndex, int toIndex, int key) {}
*/
public class Arrays {
    static int binarySearch(byte[] a, byte key) {
        return java.util.Arrays.binarySearch(a, key);
    }

    static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key);
    }

    static int binarySearch(char[] a, char key) {
        return java.util.Arrays.binarySearch(a, key);
    }

    static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key);
    }

    static int binarySearch(double[] a, double key) {
        return java.util.Arrays.binarySearch(a, key);
    }

    static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key);
    }

    static int binarySearch(float[] a, float key) {
        return java.util.Arrays.binarySearch(a, key);
    }

    static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key);
    }

    static int binarySearch(int[] a, int key) {
        return binarySearch0(a, 0, a.length, key);
    }

    static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, 0, a.length, key);
    }

    static int binarySearch(long[] a, long key) {
        return java.util.Arrays.binarySearch(a, key);
    }

    static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key);
    }

    static int binarySearch(short[] a, short key) {
        return java.util.Arrays.binarySearch(a, key);
    }

    static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key);
    }

    static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        return java.util.Arrays.binarySearch(a, key, c);
    }

    static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        return java.util.Arrays.binarySearch(a, fromIndex, toIndex, key, c);
    }

    private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    /*
    Предварительное условие, массив должен быть отсортирован по возрастанию.
    Работа алгоритма по шагам:
    1. Задаем диапазон поиска в массиве
    2. Вычисляем середину диапазона, получаем значение и сравниваем с ключом поиска
    3. Имеем три возможных варианта развития событий:
        а) если значение в середине диапазона равно ключу поиска, процесс завершается
        б) если значение в середине диапазона больше, чем значение ключа, то для следующей итерации поиска будет
            использована левая часть массива
        в) если значение в середине диапазона меньше, чем значение ключа, то для следующей итерации поиска будет
            использована правая часть массива
    4. Процесс будет продолжаться до тех пор, пока не найден индекс содержащий ключ поиска или указатель на начало
        диапазона поиска не станет равен указателю конца диапазона. В таком случае вернется отрицательное значение,
        которое можно интерпретировать как значение (взяв модуль этого числа и вычесть единицу) на какой индекс
        можно вставить ключ поиска, предварительно сдвинув следующие значения на одно место вправо, чтобы сохранить
        порядок данных в массиве. (увеличить массив если нет места)
    */
    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }
}