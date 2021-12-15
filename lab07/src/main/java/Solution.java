import java.util.*;
import java.util.stream.Collectors;

interface Command { // Interfejs polecenia z pojednyczną metodą uruchamiającą.
    void execute(ArrayList<String> commandList);
}

class Create implements Command { // Polecenie Create odpowiada za utworzenie nowej instancji klasy kwadrat, polecenie jest inicjalizowane za pośrednictwem konstruktora polecenia.

    @Override
    public void execute(ArrayList<String> commandList) {
        int i = Integer.parseInt(String.valueOf(commandList.get(0)));
        int l = Integer.parseInt(String.valueOf(commandList.get(1)));
        SquareManager.squareCollection.put(i, new Square(l));
    }
}

class Scale implements Command { // Polecenie Scale odpowiada za skalowanie kwadratu, polecenie jest inicjalizowane za pośrednictwem konstruktora polecenia.

    @Override
    public void execute(ArrayList<String> commandList) {
        int i = Integer.parseInt(String.valueOf(commandList.get(0)));
        int j = Integer.parseInt(String.valueOf(commandList.get(1)));

        Square scaledSquare = SquareManager.squareCollection.get(i);

        scaledSquare.setL(scaledSquare.getL() * j);
    }
}

class Move implements Command { // Polecenie Move odpowiada za przemieszczenie kwadratu, polecenie jest inicjalizowane za pośrednictwem konstruktora polecenia.

    @Override
    public void execute(ArrayList<String> commandList) {
        int i = Integer.parseInt(String.valueOf(commandList.get(0)));
        int j = Integer.parseInt(String.valueOf(commandList.get(1)));
        int k = Integer.parseInt(String.valueOf(commandList.get(2)));

        Square squareToMove = SquareManager.squareCollection.get(i);

        squareToMove.setJ(squareToMove.getJ() + j);
        squareToMove.setK(squareToMove.getK() + k);

    }
}

class Square { // Klasa kwadratu posiadająca pola
    private int l; // długość boku
    private int j; // współrzędna X
    private int k; // współrzędna Y

    public Square(int l) {
        this.l = l;
        this.j = 0;
        this.k = 0;
    }

    public Square(Square square) {
        this.j = square.j;
        this.k = square.k;
        this.l = square.l;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return j + " " + k + " " + l;
    }
}

class CommandHistory { // Klasa przechowywująca stos z historią operacji
    public static Stack<CommandHistoryRecord> history = new Stack<>();
    public static Stack<CommandHistoryRecord> undoHistory = new Stack<>();
    public static TreeMap<Integer, Square> squareCollection;

    public TreeMap<Integer, Square> copyState(TreeMap<Integer, Square> state) {

        Map<Integer, Square> copiedState = state
                .entrySet()
                .stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), new Square(e.getValue())))
                .collect(Collectors.toMap(
                        AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue));

        return new TreeMap<>(copiedState);
    }

    public void saveBackup() {
        TreeMap<Integer, Square> backup = copyState(squareCollection);
        undoHistory = new Stack<>();
        history.push(new CommandHistoryRecord(backup));
    }
}

class SquareManager extends CommandHistory { // Klasa SquareManager odpowiadająca za przeprowadzanie operacji undo/redo i wypisywanie listy utworzonych kwadratów

    public SquareManager() {
        squareCollection = new TreeMap<>();
    }

    public void undo() {
        try {
            CommandHistoryRecord commandHistoryRecord = history.pop();
            TreeMap<Integer, Square> backup = copyState(squareCollection);
            undoHistory.push(new CommandHistoryRecord(backup));
            squareCollection = commandHistoryRecord.squares;
        } catch (EmptyStackException e) {
            return;
        }
    }

    public void redo() {
        try {
            CommandHistoryRecord commandHistoryRecord = undoHistory.pop();
            TreeMap<Integer, Square> backup = copyState(squareCollection);
            history.push(new CommandHistoryRecord(backup));
            squareCollection = commandHistoryRecord.squares;
        } catch (EmptyStackException e) {
            return;
        }
    }

    public void print() {
        squareCollection.forEach((key, value) -> System.out.println(key + " " + value));
    }
}

class CommandExecutor extends CommandHistory { // Klasa CommandExecutor odpowiadająca za egzekwowanie komend
    public void executeCommand(Command command, ArrayList<String> commandList) {
        saveBackup();
        command.execute(commandList);
    }
}

class CommandHistoryRecord { // Klasa CommandHistoryRecord reprezentuje operację w historii komend
    public TreeMap<Integer, Square> squares;
    public CommandHistoryRecord(TreeMap<Integer, Square> squares) {
        this.squares = squares;
    }
}

class Launcher { // Klasa Launcher odpowiadająca za funkcjonowanie systemu

    public void run() {
        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();
        SquareManager squareManager = new SquareManager();
        boolean quit = false;
        while (!quit) {
            String commandString = scanner.nextLine();
            ArrayList<String> commandArguments = new ArrayList<>(Arrays.asList(commandString.split(" ")));
            String command = commandArguments.remove(0);
            switch (command) {
                case "P" -> squareManager.print();
                case "C" -> commandExecutor.executeCommand(new Create(), commandArguments);
                case "M" -> commandExecutor.executeCommand(new Move(), commandArguments);
                case "S" -> commandExecutor.executeCommand(new Scale(), commandArguments);
                case "R" -> squareManager.redo();
                case "U" -> squareManager.undo();
                default -> quit = true;
            }
        }
    }

}

public class Solution { // Klasa Solution uruchamiająca system

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.run();
    }
}
