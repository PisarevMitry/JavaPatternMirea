public class Main {
    public static void main(String[] args) {
        SingletonLazy singletonLazy = SingletonLazy.getInstance();

        SingletonEnum singletonEnum=SingletonEnum.INSTANCE;

        SingletonStatic singletonStatic=SingletonStatic.instance;

    }
}
