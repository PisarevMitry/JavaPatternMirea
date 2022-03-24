package abstractFactory;

public class OrderCoffeeForm {
    private final TextField customerNameTextField;
    private final Select coffeeTypeSelect;
    private final Button orderButton;

    public OrderCoffeeForm(GUIFactory factory) {
        System.out.println("Creating order coffee form");
        customerNameTextField = factory.createTextField();
        coffeeTypeSelect = factory.createSelect();
        orderButton = factory.createButton();
    }
}
