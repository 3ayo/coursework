System.out.println("Enter the grades separated by commas: ");
String gradeInput = $1; // 读取用户输入的第一个字符串，包含用逗号分隔的分数
String[] stringNumbers = gradeInput.split(",");

System.out.println("Enter the weights separated by commas: ");
String weightInput = $2; // 读取用户输入的第二个字符串，包含用逗号分隔的权重
String[] weightStrings = weightInput.split(",");
int[] weights = new int[weightStrings.length];
for (int i = 0; i < weightStrings.length; i++) {
    weights[i] = Integer.parseInt(weightStrings[i].trim());
}

int[][] grades = new int[stringNumbers.length][];
for (int i = 0; i < stringNumbers.length; i++) {
    grades[i] = new int[stringNumbers[i].split(",").length];
    for (int j = 0; j < grades[i].length; j++) {
        grades[i][j] = Integer.parseInt(stringNumbers[i].split(",")[j].trim());
    }
}

int[] averages = average_grades(grades, weights);

for (int i = 0; i < averages.length; i++) {
    System.out.println("Student " + (i + 1) + "'s weighted average grade: " + averages[i]);
}

int[] average_grades(int[][] grades, int[] weights) {
    int students = grades.length;
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