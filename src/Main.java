import controller.CharacterController;
import view.CharacterForm;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CharacterForm view = new CharacterForm();
            new CharacterController(view);
        });
    }
}