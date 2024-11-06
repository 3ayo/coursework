import java.util.Scanner;
public class WeightedAverageOfGrades{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组的大小: ");
        int size = scanner.nextInt(); 

        // 根据输入的大小创建数组
        int[] grades = new int[size];

        System.out.println("请输入成绩数组的元素:");
        for (int j = 0; j < size; j++) {
            grades[j] = scanner.nextInt(); 
        }

        int[] weights = new int[size];

        System.out.println("请输入加权数组的元素:");
        for (int j = 0; j < size; j++) {
            weights[j] = scanner.nextInt(); 
        }

        scanner.close();

        int[] averages = average_grades(grades, weights);
        System.out.println("加权平均分为:");
        for (int average : averages) {
            System.out.println(average);
        }


    }

    public static int[] average_grades(int[] grades, int[] weights) {
        int students=1;
        int[] averages = new int[students];

        for (int i = 0; i < students; i++) {
            int sum = 0;
            for (int j = 0; j < grades.length; j++) {
                sum += grades[j] * weights[j];
            }
            averages[i] = sum / 100;
        }

        return averages;
    }
}