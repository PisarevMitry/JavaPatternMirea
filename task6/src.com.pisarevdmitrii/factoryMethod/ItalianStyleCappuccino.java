package factoryMethod;

public class ItalianStyleCappuccino extends  Coffee{
    @Override
    public void makeCoffee() {
        System.out.println("Приготовили ItalianStyleCappuccino");
    }
}
