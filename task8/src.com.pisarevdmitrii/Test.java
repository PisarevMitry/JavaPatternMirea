import observer.CurrentConditionsDisplay;
import observer.Observer;
import observer.WeatherData;
import state.LiquidState;
import state.StateContext;

/**
 * todo Document type Test
 */
public class Test {

    public static void main(String[] args) {
       // observerPattern();
        statePattern();
    }

    public static void observerPattern() {
        System.out.println("===========Observer pattern===========");
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay();
        Observer currentDisplay2 = new CurrentConditionsDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(currentDisplay2);

        weatherData.setMeasurements(29f, 65f, 745);
        weatherData.setMeasurements(39f, 70f, 760);
        weatherData.setMeasurements(42f, 72f, 763);
    }

    public static void statePattern() {
        System.out.println("===========State pattern===========");
        StateContext context = new StateContext(new LiquidState());
        context.heat();
        context.heat();
        context.heat();
        context.freeze();
        context.freeze();
        context.freeze();
    }
}
