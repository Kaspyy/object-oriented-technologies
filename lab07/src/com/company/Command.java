package com.company;

public abstract class Command {
    public Square square;

    Command (Square square) {
        this.square = square;
    }
    public abstract void execute();
}
