import java.util.Scanner;
public class WeightedAverageOfGrades{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the grades separated by commas: ");
        String gradeinput = sc.next();
        String[] stringNumbers = gradeInput.split(",");
        int[][] grades=new int[stringNumbers.length];
        
        System.out.println("Enter the weightss separated by commas: ");
        String weightinput = scanner.next();
        int[] weights =new int[stringNumbers.length];
        String[] weightStrings = weightInput.split(",");
        int[] averages = average_grades(grades, weights);
        
        for (int i = 0; i < averages.length; i++) {
            System.out.println("Student " + (i + 1) + "'s weighted average grade: " + averages[i]);
        }

    }

    public static int[] average_grades(int grades[][], int weights[]) {
        int students=grades.length;
        int[] averages = new int[students];

        for (int i = 0; i < students; i++) {
            int sum = 0;
            for (int j = 0; j < grades[i].length; j++) {
                sum += grades[i][j] * weights[j];
            }
            averages[i] = sum / 100;
        }

        return averages;
    }

}