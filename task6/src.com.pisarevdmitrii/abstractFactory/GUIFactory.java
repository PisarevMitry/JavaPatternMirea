package abstractFactory;

public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    Select createSelect();
}
