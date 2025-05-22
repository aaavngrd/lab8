package controller;

import model.*;
import model.Character;
import view.CharacterForm;
import org.json.simple.JSONObject;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterController {
    private CharacterForm view;
    private CareTaker careTaker = new CareTaker();
    private Character currentCharacter;

    public CharacterController(CharacterForm view) {
        this.view = view;

        view.setGenerateListener(this::generate);
        view.setSaveStateListener(this::saveState);
        view.setSaveJsonListener(this::saveJson);
        view.setRestoreListener(this::restoreSelected);
    }

    private void generate(ActionEvent e) {
        Stats newStats = Stats.generateRandom();
        currentCharacter = new Character(
                view.getNameInput(),
                view.getSelectedRace(),
                view.getSelectedClass(),
                newStats
        );
        view.updateStats(newStats);
    }


    private void saveState(ActionEvent e) {
        if (currentCharacter == null) return;
        Memento memento = currentCharacter.getStats().saveStateToMemento();
        careTaker.save(memento);
        view.addSavedState(memento.toString());
    }

    private void restoreSelected(ActionEvent e) {
        if (currentCharacter == null || careTaker.isEmpty()) return;
        int index = view.getSelectedStateIndex();
        Memento memento = careTaker.get(index);
        if (memento != null) {
            currentCharacter.getStats().restoreFromMemento(memento);
            view.updateStats(currentCharacter.getStats());
        }
    }

    private void saveJson(ActionEvent e) {
        if (currentCharacter == null) return;

        JSONObject json = new JSONObject();
        json.put("name", currentCharacter.getName());
        json.put("race", currentCharacter.getRace().toString());
        json.put("class", currentCharacter.getCharacterClass().toString());

        JSONObject statsJson = new JSONObject();
        String[] statNames = {"strength", "dexterity", "intelligence", "wisdom", "charisma", "constitution"};
        int[] statValues = currentCharacter.getStats().toArray();
        for (int i = 0; i < statNames.length; i++) {
            statsJson.put(statNames[i], statValues[i]);
        }
        json.put("stats", statsJson);

        try (FileWriter writer = new FileWriter("characters.json", true)) {
            writer.write(json.toJSONString());
            writer.write(",\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}