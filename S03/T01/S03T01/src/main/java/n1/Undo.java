package n1;

import java.io.Console;
import java.util.LinkedList;

public class Undo {

    private static Undo _instance;

    public static Undo Instance() {
        if (_instance == null)
            _instance = new Undo();
        return _instance;
    }

    public void showCommands() {
        System.out.println("Commands:");
        for (int i = 0; i < _commands.size(); i++) {
            System.out.println((i + 1) + ". " + _commands.get(i));
        }
        System.out.println("");
    }

    public void addCommand(String command) {
        _commands.add(command);
    }

    public void removeCommand(int index) {
        if (_commands.size() >= index)
            _commands.remove(index - 1);
    }

    private LinkedList<String> _commands = new LinkedList<>();

}
