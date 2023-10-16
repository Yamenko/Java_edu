import java.util.Arrays;
import java.util.ArrayList;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        // Введите свое решение ниже
        sort(arr);
    }

    public static void sort(Integer[] mas) {

        int count = mas.length, sum = 0, aver = 0;
        while (count != 0) {
            count = 0;
            sum = mas[mas.length - 1];
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i+1]) {
                    int pock = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = pock;
                    count++;
                }
                sum += mas[i];
            }
            aver = sum  / mas.length;
        }
        System.out.println(Arrays.toString(mas));
        System.out.println("Minimum is " + mas[0]);
        System.out.println("Maximum is " + mas[mas.length - 1]);
        System.out.println("Average is = " + aver);
    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class hw_3_task_2{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}