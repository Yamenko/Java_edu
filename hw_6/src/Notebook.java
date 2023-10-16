/*
Под каждый блок можно сделать отдельный класс
*/

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Notebook {
    public Notebook(){
        this.id = this.hashCode();
        this.modelName = "Model_" + this.id;
        this.RAM_capacity = 1024 * (int)Math.pow(2, new Random().nextInt(1, 6));
        this.CPU_frequency = CPU_freq_list[new Random().nextInt(0, CPU_freq_list.length)];
        this.HDD_capacity = HDD_capacity_list[new Random().nextInt(0, HDD_capacity_list.length)];
        this.GPU_RAM_capacity = 1024 * (int)Math.pow(2, new Random().nextInt(1, 4));
    }
    Integer id;
    String modelName;
    Color color = Color.values()[new Random().nextInt(0, Color.values().length)];

    // Ram block
    RAM_Type RAM_type = RAM_Type.values()[new Random().nextInt(0, RAM_Type.values().length)];
    Integer RAM_capacity;

    // CPU block
    CPU_Type CPU_type = CPU_Type.values()[new Random().nextInt(0, CPU_Type.values().length)];
    Integer CPU_frequency;

    //HDD/SSD
    Integer HDD_capacity;

    // GPU/Video
    RAM_Type GPU_RAM_type = RAM_Type.values()[new Random().nextInt(0, RAM_Type.values().length)];
    Integer GPU_RAM_capacity;

    // Screen
    Screen_Size Screen_size = Screen_Size.values()[new Random().nextInt(0, Screen_Size.values().length)];
    Screen_Type Screen_type = Screen_Type.values()[new Random().nextInt(0, Screen_Type.values().length)];
    Screen_Resolution Screen_resolution = Screen_Resolution.values()[new Random().nextInt(0, Screen_Resolution.values().length)];

    private Integer[] CPU_freq_list = {2400, 2800, 3000, 3200, 3600, 4000};
    private Integer[] HDD_capacity_list = {128, 512, 1024, 2048};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return color == notebook.color && RAM_type == notebook.RAM_type && Objects.equals(RAM_capacity, notebook.RAM_capacity) && CPU_type == notebook.CPU_type && Objects.equals(CPU_frequency, notebook.CPU_frequency) && Objects.equals(HDD_capacity, notebook.HDD_capacity) && GPU_RAM_type == notebook.GPU_RAM_type && Objects.equals(GPU_RAM_capacity, notebook.GPU_RAM_capacity) && Screen_size == notebook.Screen_size && Screen_type == notebook.Screen_type && Screen_resolution == notebook.Screen_resolution && Arrays.equals(CPU_freq_list, notebook.CPU_freq_list) && Arrays.equals(HDD_capacity_list, notebook.HDD_capacity_list);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(color, RAM_type, RAM_capacity, CPU_type, CPU_frequency, HDD_capacity, GPU_RAM_type, GPU_RAM_capacity, Screen_size, Screen_type, Screen_resolution);
        result = 31 * result + Arrays.hashCode(CPU_freq_list);
        result = 31 * result + Arrays.hashCode(HDD_capacity_list);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Notebook{id = %d, modelName: %s, color: %s, RAM: %d(%s), CPU: %s(%d), HDD = %d, GPU: %s(%d), Screen: %s(%s) %s}",
                id, modelName, color, RAM_capacity, RAM_type, CPU_type, CPU_frequency, HDD_capacity, GPU_RAM_type, GPU_RAM_capacity,
                Screen_size, Screen_type, Screen_resolution);
    }
}

enum RAM_Type { DDR3, DDR4, DDR5, DDR6 };
enum CPU_Type{ AMD2, AMD3, I5, I7, I9 };
enum Screen_Type {TN, IPS, OLED};
enum Screen_Resolution {x1920x1080, x2560x1440, x3840x2160};
enum Screen_Size {inch14, inch15, inch17, inch19, inch22, inch24 };
enum Color {Black, White, Pink, Silver};


