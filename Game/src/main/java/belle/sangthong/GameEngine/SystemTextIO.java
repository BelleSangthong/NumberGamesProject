package belle.sangthong.GameEngine;

import belle.sangthong.interfaces.TextIO;

import java.util.Scanner;

public class SystemTextIO implements TextIO {
    private final Scanner scanner;

    public SystemTextIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        System.out.print("Y/N: ");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("y");
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public void addString(String s) {
        System.out.print(s);
    }

    @Override
    public void clear() {
        System.out.println("Sudda sudda");
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
