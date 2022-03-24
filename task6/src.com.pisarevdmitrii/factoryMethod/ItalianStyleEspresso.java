package factoryMethod;

public class ItalianStyleEspresso extends  Coffee{
    @Override
    public void makeCoffee() {
        System.out.println("Приготовили ItalianStyleEspresso");
    }
}
