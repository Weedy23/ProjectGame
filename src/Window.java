import java.util.Scanner;

public class Window {
    public static void Print(String text) {
        System.out.println(text);
    }

    public static String getText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
