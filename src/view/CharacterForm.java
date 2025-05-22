package view;

import model.Race;
import model.CharacterClass;
import model.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CharacterForm extends JFrame {
    private JTextField nameField = new JTextField(15);
    private JComboBox<Race> raceBox = new JComboBox<>(Race.values());
    private JComboBox<CharacterClass> classBox = new JComboBox<>(CharacterClass.values());
    private JButton generateBtn = new JButton("Generate");
    private JButton saveStateBtn = new JButton("Save State");
    private JButton restoreBtn = new JButton("Restore Selected");
    private JTextArea statsArea = new JTextArea(6, 20);
    private JButton saveJsonBtn = new JButton("Save to JSON");
    private JComboBox<String> savedStatesBox = new JComboBox<>();

    public CharacterForm() {
        setTitle("DnD Character Generator");
        setLayout(new FlowLayout());
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Race:"));
        add(raceBox);
        add(new JLabel("Class:"));
        add(classBox);
        add(generateBtn);
        add(saveStateBtn);
        add(savedStatesBox);
        add(restoreBtn);
        add(saveJsonBtn);
        add(new JScrollPane(statsArea));
        statsArea.setEditable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 350);
        setVisible(true);
    }

    public String getNameInput() { return nameField.getText(); }
    public Race getSelectedRace() { return (Race) raceBox.getSelectedItem(); }
    public CharacterClass getSelectedClass() { return (CharacterClass) classBox.getSelectedItem(); }

    public void updateStats(Stats stats) {
        statsArea.setText(String.join("\n", stats.toStringArray()));
    }

    public void addSavedState(String label) {
        savedStatesBox.addItem(label);
    }

    public int getSelectedStateIndex() {
        return savedStatesBox.getSelectedIndex();
    }

    public void setGenerateListener(ActionListener l) { generateBtn.addActionListener(l); }
    public void setSaveStateListener(ActionListener l) { saveStateBtn.addActionListener(l); }
    public void setSaveJsonListener(ActionListener l) { saveJsonBtn.addActionListener(l); }
    public void setRestoreListener(ActionListener l) { restoreBtn.addActionListener(l); }
}
