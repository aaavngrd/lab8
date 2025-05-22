package model;

import java.util.Arrays;

public class Dice {
    public static int roll() {
        return (int)(Math.random() * 6) + 1;
    }

    public static int rollStat() {
        int[] rolls = new int[6];
        for (int i = 0; i < 6; i++) {
            rolls[i] = roll();
        }
        Arrays.sort(rolls);
        return rolls[3] + rolls[4] + rolls[5];
    }
}
