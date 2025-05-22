package model;

import java.util.Arrays;

public class Memento {
    private final int[] stats;

    public Memento(int str, int dex, int intel, int wis, int cha, int con) {
        this.stats = new int[]{str, dex, intel, wis, cha, con};
    }

    public int[] getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return Arrays.toString(stats);
    }
}

