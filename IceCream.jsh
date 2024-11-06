import java.util.Scanner;

String getUserInput(Scanner scanner) {
    scanner.nextLine(); // 消耗掉之前的换行符
    return scanner.nextLine();
}

int getScoop(Scanner scanner) {
    System.out.println("How many scoops would you like?");
    while (!scanner.hasNextInt()) {
        System.out.println("Invalid input. Please enter a number:");
        scanner.next(); // 消耗掉非整数输入
    }
    int scoop = scanner.nextInt();

    if (scoop > 3) {
        System.out.println("That's too many scoops to fit in a cone.");
        return 3;
    } else if (scoop < 1) {
        System.out.println("We don't sell just a cone.");
        return -1;
    }
    return scoop;
}

void start() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter your number.");
    int a = sc.nextInt(); // 32803852
    int vanillaPrice = a % 100;
    int chocolatePrice = (a / 100) % 100;
    int strawberryPrice = (a / 10000) % 100;
    System.out.println("The price of vanilla ice cream is " + vanillaPrice + " per scoop");
    System.out.println("The price of chocolate ice cream is " + chocolatePrice + " per scoop");
    System.out.println("The price of strawberry ice cream is " + strawberryPrice + " per scoop");

    System.out.print("Would you like (v)anilla, (c)hocolate or (s)trawberry? (v/c/s) ");
    String choice = getUserInput(sc);

    int scoop = getScoop(sc);
    int cost = 0;

    if (choice.equalsIgnoreCase("v") && scoop > 0) {
        cost = scoop * vanillaPrice;
    } else if (choice.equalsIgnoreCase("s") && scoop > 0) {
        cost = scoop * strawberryPrice;
    } else if (choice.equalsIgnoreCase("c") && scoop > 0) {
        cost = scoop * chocolatePrice;
    } else {
        System.out.println("We don't have that flavour.");
    }
    sc.close();
    System.out.println("The total cost is " + cost);
}

// 调用 start 方法来运行程序
start();