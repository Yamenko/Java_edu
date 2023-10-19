
/*
Подумать над структурой класса Ноутбук для магазина техники
выделить поля и методы.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
 */

import java.util.*;
import java.util.concurrent.Callable;


public class Main {
    static HashMap<Integer, Object>SearchParams = new HashMap<>();
    static List<Notebook>Book_list = new ArrayList<>() {
    };
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        // Заполним  множество буков
        for (int i = 0; i < 100; i++) {
            Notebook tmp_book = new Notebook();
            if (!Book_list.contains(tmp_book)){
                Book_list.add(tmp_book);
            }
        }

        boolean program_run = true;
        Integer choose = 0;
        Integer[] RamCapasity = {1024, 2048, 4096, 8192, 16384, 32768};
        Integer[] HDDCapacity = {128, 256, 512, 1024, 2048};
        Integer[] CPUFrequency = {2400, 2800, 3000, 3200, 3600, 4000};

        // цикл основной программы
        while (program_run){
            System.out.println("1 RAM type");
            System.out.println("2 RAM capacity");
            System.out.println("3 CPU type");
            System.out.println("4 CPU Frequency");
            System.out.println("5 HDD/SSD");
            System.out.println("6 GPU RAM type");
            System.out.println("7 GPU RAM capacity");
            System.out.println("8 Screen type");
            System.out.println("9 Screen size");
            System.out.println("10 Screen resolution");
            System.out.println("11 Color");
            System.out.println("12 Search...");
            System.out.println("13 Clear search");
            System.out.println("0 for exit");
            System.out.println();
            System.out.println("Выберите параметр: ");

            choose = console.nextInt();
            switch (choose){
                case 1:    SetParam(choose, RAM_Type.values());                 break;
                case 2:    SetParam(choose, RamCapasity);                       break;
                case 3:    SetParam(choose, CPU_Type.values());                 break;
                case 4:    SetParam(choose, CPUFrequency);                      break;
                case 5:    SetParam(choose, HDDCapacity);                       break;
                case 6:    SetParam(choose, RAM_Type.values());                 break;
                case 7:    SetParam(choose, RamCapasity);                       break;
                case 8:    SetParam(choose, Screen_Type.values());              break;
                case 9:    SetParam(choose, Screen_Size.values());              break;
                case 10:   SetParam(choose, Screen_Resolution.values());        break;
                case 11:   SetParam(choose, Color.values());                    break;
                case 12:   Search();                                            break;
                case 13:   SearchParams.clear();                                break;

                case 0: program_run = false;
            }
        }
    }

    public static void Search() {
        if (SearchParams.isEmpty()) {
            System.out.println("Вы не выбрали никаких параметров. Вывести первых 10? (y/n)");
            if (console.next().equals("y")) {
                int l = Math.min(Book_list.size(), 10);
                for (int i = 0; i < l; i++) {
                    System.out.println(Book_list.get(i).toString());
                }
            }
        } else {

            for (Notebook n : Book_list) {
                boolean found = true;
                for (Map.Entry<Integer, Object> element : SearchParams.entrySet()) {
                    if (found) {
                        switch (element.getKey()) {
                            case 1: if (!n.RAM_type.equals(element.getValue())) { found = false; }    break;
                            case 2: if (!n.RAM_capacity.equals(element.getValue())) { found = false;} break;
                            case 3: if (!n.CPU_type.equals(element.getValue())) { found = false; }    break;
                            case 4: if (!n.CPU_frequency.equals(element.getValue())) { found = false; } break;
                            case 5: if (!n.HDD_capacity.equals(element.getValue())) {found = false; } break;
                            case 6: if (!n.GPU_RAM_type.equals(element.getValue())) {found = false; } break;
                            case 7: if (!n.GPU_RAM_capacity.equals(element.getValue())) {found = false;}break;
                            case 8: if (!n.Screen_type.equals(element.getValue())) {found = false; } break;
                            case 9: if (!n.Screen_size.equals(element.getValue())) { found = false;}  break;
                            case 10:if (!n.Screen_resolution.equals(element.getValue())) {found = false; } break;
                            case 11:if (!n.color.equals(element.getValue())) {found = false; } break;
                        }
                    } else {
                        break;
                    } // Если одну не точность выходим и берем следующий бук

                }
                if (found) {
                    System.out.println(n.toString());
                }
            }
        }
    }
    private static void SetParam(Integer indx, Object[] obj){
        for (int i = 0; i < obj.length; i++) {
            System.out.print(i + " - " + obj[i] + ", ");
        }
        System.out.println();
        System.out.println("Choose param: ");
        int tmp = console.nextInt();

        if (tmp >= 0 && tmp < obj.length ) {
            SearchParams.put(indx, obj[tmp]);
        }
        else{
            SearchParams.remove(indx);
        }
    }


    /**
     *  enum RAM_Type { DDR3, DDR4, DDR5, DDR6 };
     * enum CPU_Type{ AMD2, AMD3, I5, I7, I9 };
     * enum Screen_Type {TN, IPS, OLED};
     * enum Screen_Resolution {x1920x1080, x2560x1440, x3840x2160};
     * enum Screen_Size {inch14, inch15, inch17, inch19, inch22, inch24 };
     * enum Color {Black, White, Pink, Silver};
     *
     *
     */

}