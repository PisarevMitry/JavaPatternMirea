package factoryMethod;

public abstract class Coffee {
    // делаем кофе
    public abstract void makeCoffee();

    public void pourIntoCup() {
        System.out.println("...кофе наливается");
    }
}