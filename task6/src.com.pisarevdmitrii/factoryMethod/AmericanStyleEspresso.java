package factoryMethod;

public class AmericanStyleEspresso extends  Coffee{
    @Override
    public void makeCoffee() {
        System.out.println("Приготовили AmericanStyleEspresso");
    }
}
