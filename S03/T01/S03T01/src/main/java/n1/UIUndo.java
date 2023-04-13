package n1;

import java.util.Scanner;

public class UIUndo {
    Scanner _scanner = new Scanner(System.in);

    public void StartUI() {
        DisplayMenu();
    }

    private void DisplayMenu() {
        System.out.println("");
        System.out.println("Select an option: ");
        int option = -1;
        while (option != 0) {
            System.out.println("1. Show commands");
            System.out.println("2. Add command");
            System.out.println("3. Remove command");
            System.out.println("0. Exit");

            option = _scanner.nextInt();
            _scanner.nextLine();
            System.out.println("");

            if(option != 0)
            ProcessOption(option);
        }
    }

    private void ProcessOption(int option) {
        switch (option) {
            case 1 -> Undo.Instance().showCommands();
            case 2 -> ShowAddCommandOption();
            case 3 -> ShowRemoveCommandOption();
            case 0 -> System.out.println("Application quit.");
        }

    }

    private void ShowAddCommandOption() {
        System.out.println("Insert a command: ");
        String cmd = _scanner.nextLine();
        Undo.Instance().addCommand(cmd);
    }

    private void ShowRemoveCommandOption() {
        System.out.println("Insert an option to remove: ");
        int cmd = _scanner.nextInt();
        _scanner.nextLine();
        Undo.Instance().removeCommand(cmd);
    }
}


