import java.util.Arrays;

class MergeSort {
    public static int[] mergeSort(int[] a) {
        // Напишите свое решение ниже
        sorter(a, 0, a.length-1);
        return a;
    }

    private static void sorter(int[] a, int l, int r){
        if (l < r) {
            int m = (l+r) / 2;
            sorter(a, l, m);
            sorter(a, m + 1, r);
            sortHalf(a, l, r);
        }
    }

    private static void sortHalf(int[] a, int l, int r)
    {
        int[] tmp = new int[r - l + 1];
        int middle = (l + r) / 2;	//вычисление среднего элемента
        int first_half = l;				//начало левой части
        int second_half = middle + 1;		//начало правой части
        int counter = 0;
        for (int i = l; i <= r; i++) {
            if (first_half <= middle && (second_half > r || a[first_half] < a[second_half])) {
                tmp[counter++] = a[first_half++];
            }
            else {
                tmp[counter++] = a[second_half++];
            }
        }

        // возвращаем отсортированные элементы обратно в наш массив
        for (int i = l, k = 0; i <= r; i++, k++){
            a[i] = tmp[k];
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class hw_3_task_1{
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}