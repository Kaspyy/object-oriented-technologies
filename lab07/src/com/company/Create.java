package com.company;

public class Create extends Command {
    public static int i;
    public static int l;

    Create(Square square) {
        super(square);
    }

    @Override
    public void execute() {
        Square square = new Square(i, l);
    }
}
