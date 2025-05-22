package model;

public class Stats {
    private int strength, dexterity, intelligence, wisdom, charisma, constitution;

    public Stats(int str, int dex, int intel, int wis, int cha, int con) {
        this.strength = str;
        this.dexterity = dex;
        this.intelligence = intel;
        this.wisdom = wis;
        this.charisma = cha;
        this.constitution = con;
    }

    public Stats(Stats other) {
        this(other.strength, other.dexterity, other.intelligence, other.wisdom, other.charisma, other.constitution);
    }

    public static Stats generateRandom() {
        return new Stats(
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat()
        );
    }

    public int[] toArray() {
        return new int[] { strength, dexterity, intelligence, wisdom, charisma, constitution };
    }

    public String[] toStringArray() {
        return new String[] {
                "Strength: " + strength,
                "Dexterity: " + dexterity,
                "Intelligence: " + intelligence,
                "Wisdom: " + wisdom,
                "Charisma: " + charisma,
                "Constitution: " + constitution
        };
    }

    public Memento saveStateToMemento() {
        return new Memento(strength, dexterity, intelligence, wisdom, charisma, constitution);
    }

    public void restoreFromMemento(Memento memento) {
        int[] stats = memento.getStats();
        this.strength = stats[0];
        this.dexterity = stats[1];
        this.intelligence = stats[2];
        this.wisdom = stats[3];
        this.charisma = stats[4];
        this.constitution = stats[5];
    }
}
