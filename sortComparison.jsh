import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

// 定义 cardCompare 函数
int cardCompare(String card1, String card2) {
    String customOrder = "HCDS";
    String letterPart1 = card1.replaceAll("\\d", "");
    String numberPart1 = card1.replaceAll("[a-zA-Z]", "");
    String letterPart2 = card2.replaceAll("\\d", "");
    String numberPart2 = card2.replaceAll("[a-zA-Z]", "");

    // 验证输入是否有效
    if (!isValidInput(card1) || !isValidInput(card2)) {
        throw new IllegalArgumentException("输入无效，请确保输入的格式为字母（H, C, D, S）后跟1-13之间的数字。");
    }

    // 比较字母部分
    int letterIndex1 = customOrder.indexOf(letterPart1.toUpperCase());
    int letterIndex2 = customOrder.indexOf(letterPart2.toUpperCase());
    if (letterIndex1 != letterIndex2) {
        return Integer.compare(letterIndex1, letterIndex2);
    } else {
        // 字母部分相同，比较数字部分
        return Integer.compare(Integer.parseInt(numberPart1), Integer.parseInt(numberPart2));
    }
}

// 定义辅助函数来验证输入
boolean isValidInput(String input) {
    String letterPart = input.replaceAll("\\d", "");
    String numberPart = input.replaceAll("[a-zA-Z]", "");
    if (letterPart.isEmpty() || numberPart.isEmpty() || numberPart.length() > 2) {
        return false;
    }
    if (!"HCDS".contains(letterPart) || Integer.parseInt(numberPart) < 1 || Integer.parseInt(numberPart) > 13) {
        return false;
    }
    return true;
}

ArrayList<String> bubbleSort(ArrayList<String> list){
        int n=list.size();
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                int result=cardCompare(list.get(j),list.get(j+1));
                if(result>0){
                    String temp=list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

ArrayList<String> mergeSort(ArrayList<String> list) {
    MergeSort(list,0,list.size()-1);
    return list;
}

void MergeSort(ArrayList<String> list, int s, int t) {
    if (s < t) {
        int m = (s + t) / 2;
        MergeSort(list, s, m);
        MergeSort(list, m + 1, t);
        merge(list, s, m, t);
    }
}

void merge(ArrayList<String> list, int s, int m, int t) {
    ArrayList<String> r1 = new ArrayList<>();
    int i = s, j = m + 1, k = 0;
    while (i <= m && j <= t) {
        if (cardCompare(list.get(i), list.get(j)) <=0) {
            r1.add(list.get(i++));
        } else {
            r1.add(list.get(j++));
        }
    }
    while (i <= m) {
        r1.add(list.get(i++));
    }
    while (j <= t) {
        r1.add(list.get(j++));
    }
    for (i = s; i <= t; i++) {
        list.set(i, r1.get(k++));
    }
}

ArrayList<String> readFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            return new ArrayList<>(lines);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
}


long measureBubbleSort(String filename){
             ArrayList<String> list = readFromFile(filename);
             long startTime = System.currentTimeMillis();
             bubbleSort(list);
             long endTime = System.currentTimeMillis(); // 结束时间
             return endTime - startTime; // 计算持续时间
}

long measureMergeSort(String filename){
            ArrayList<String> list = readFromFile(filename);
            long startTime = System.currentTimeMillis();
            mergeSort(list);
            long endTime = System.currentTimeMillis(); // 结束时间
            return endTime - startTime; // 计算持续时间
}