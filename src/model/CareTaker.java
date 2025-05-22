package model;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private final List<Memento> history = new ArrayList<>();

    public void save(Memento memento) {
        history.add(memento);
    }

    public List<Memento> getAll() {
        return history;
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public Memento get(int index) {
        if (index >= 0 && index < history.size()) {
            return history.get(index);
        }
        return null;
    }
}