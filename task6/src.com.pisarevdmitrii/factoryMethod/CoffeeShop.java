package factoryMethod;

public abstract class CoffeeShop {

    public Coffee orderCoffee(CoffeeType type) { //во всех магазинах могут заказать кофе
        Coffee coffee = createCoffee(type);

        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
        return coffee;
    }

    protected abstract Coffee createCoffee(CoffeeType type); //в каждом магазине своё приготовление
}