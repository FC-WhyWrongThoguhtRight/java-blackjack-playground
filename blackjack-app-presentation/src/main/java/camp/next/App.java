package camp.next;

import camp.next.console.AppConsole;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AppConsole appConsole = new AppConsole();
        run(appConsole);
    }

    private static void run(AppConsole appConsole) {
        Scanner sc = new Scanner(System.in);
        while (!appConsole.isShutdown()) {
            System.out.print(appConsole.flush());
            appConsole.process(sc.nextLine());
        }
        System.out.print(appConsole.flush());
    }
}
