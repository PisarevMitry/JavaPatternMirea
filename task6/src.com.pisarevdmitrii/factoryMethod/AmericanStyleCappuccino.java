package factoryMethod;

public class AmericanStyleCappuccino extends  Coffee{
    @Override
    public void makeCoffee() {
        System.out.println("Приготовили AmericanStyleCappuccino");
    }
}
