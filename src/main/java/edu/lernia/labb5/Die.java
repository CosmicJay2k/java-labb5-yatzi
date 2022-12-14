package edu.lernia.labb5;

public class Die extends BoardGameMaterial {
    public int value;

    public Die() {
        this.value = 0;
    }

    public int DieRoll() {
        value = (int) (Math.random() * 6 + 1);
        return value;
    }

    public int DieReroll() {
        return DieRoll();
    }

    public String getString() {
        return "Dice shows " + value;
    }
}
