package model;

public class Character {
    private String name;
    private Race race;
    private CharacterClass characterClass;
    private Stats stats;

    public Character(String name, Race race, CharacterClass characterClass, Stats stats) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.stats = stats;
    }

    public Character(Character other) {
        this.name = other.name;
        this.race = other.race;
        this.characterClass = other.characterClass;
        this.stats = new Stats(other.stats);
    }

    public String getName() { return name; }
    public Race getRace() { return race; }
    public CharacterClass getCharacterClass() { return characterClass; }
    public Stats getStats() { return stats; }
}

